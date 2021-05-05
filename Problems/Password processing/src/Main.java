import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class UserProfile implements Serializable {
    private static final long serialVersionUID = 26292552485L;

    private String login;
    private String email;
    private transient String password;

    public UserProfile(String login, String email, String password) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    // implement readObject and writeObject properly

    private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException {
        login = aInputStream.readUTF();
        email = aInputStream.readUTF();
        password = passwordDecryption(aInputStream.readUTF());

    }

    private void writeObject(ObjectOutputStream aOutputStream) throws IOException {
        aOutputStream.writeUTF(getLogin());
        aOutputStream.writeUTF(getEmail());
        aOutputStream.writeUTF(passwordEncryption(getPassword()));

    }

    private String passwordEncryption(String password) {
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ((int) chars[i] + 1);
        }
        return String.valueOf(chars);
    }

    private String passwordDecryption(String password) {
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ((int) chars[i] - 1);
        }
        return String.valueOf(chars);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}