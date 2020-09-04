package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacts {
    private int id;
    private String name;
    private String surname;
    private String phoneNumber = "";
    private boolean hasNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = checkNumberValidity(phoneNumber) ? phoneNumber : "";

    }

    private void setHasNumber() {
        this.hasNumber = !this.phoneNumber.equals("");

    }

    public boolean HasNumber() {
        setHasNumber();
        return hasNumber;
    }

    private boolean checkNumberValidity(String phoneNumber) {

        String pat = "^(\\+?\\(\\d{1,3}\\)()?)[\\-\\s]?((\\d{2,4})|\\d{2,4})[\\-\\s]?(\\d{2,4})[\\-\\s]?(\\d{2,4})[\\-\\s]?([a-zA-Z0-9]{1,4})?$"
                + "|^(\\+?\\d{1,3}( )?)?(\\d{2,4}[\\s\\-]?){1,4}\\d{1,4}$"
                + "|^(\\+\\([a-zA-Z]{2,}\\)[ ]?)$"
                + "|^(\\+?\\d{1,3}?()?)?[- ]((\\(\\d{2,4}\\))|\\d{2,4})[-\\s]?(\\d{2,4}){0,4}$"
                + "|^(\\+?\\d{1,3}( )?)?[\\s-](\\d{2}[ -]?){2}\\d{2}$"
                + "|^(\\+?\\(?\\d{1,3}\\)?)$"
                + "|^(\\+?\\d{1,3}?()?)?[-\\s]((\\(\\d{2,4}\\))|\\d{2,4})[-\\s]?(\\d{2,4})[- ]?(\\d{2,4})[-\\s]?([a-zA-Z0-9]{1,4})?$"
                + "|^(\\+?\\(?\\d{1,3}\\)?)[-\\s]?[a-zA-Z]{0,4}$"
                + "|^(\\+?\\d{1,3}( )?)?(\\d{2,4}[\\s\\-]?){1,4}\\d{1,4}[\\s\\-]?[a-zA-Z]{0,4}$"
                + "|^(\\+?\\d{1,3}( )?)?(\\d{2,4}[\\s\\-]?){1,4}\\d{1,4}[\\s\\-]?[a-zA-Z]{0,4}[\\s\\-]?\\d{0,4}$";

        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    @Override
    public String toString() {

        return getId() + "." + " " + getName() + " " + getSurname() + "," + " " + (HasNumber() ? getPhoneNumber() : " [no number]");
    }
}
