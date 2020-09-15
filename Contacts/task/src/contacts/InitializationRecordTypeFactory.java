package contacts;

public class InitializationRecordTypeFactory {

    public AbstractRecord createRecordType(String type) {
        if (type == null || type.isEmpty())
            return null;
        if ("person".equals(type)){
            return new Person();
        } else if("organization".equals(type))
        {
            return new Organization();
        }
        return null;
    }
}
