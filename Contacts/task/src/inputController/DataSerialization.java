package inputController;

import java.io.*;

public final class DataSerialization {
    //TODO add the serializable feature here
    //TODO Add File saving feature, consider commandline arguments while checking the file
    public static void serialize(Object o, String fileName) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        try (ObjectOutput output = new ObjectOutputStream(bufferedOutputStream)) {
            output.writeObject(o);
        }
    }
    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        try (ObjectInput objectInput = new ObjectInputStream(bufferedInputStream)){
           return objectInput.readObject();
        }
    }

}
