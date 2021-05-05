package inputController;

import domain.Contact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CrudRealization implements RepositoryCrud {

    private static CrudRealization crudRealization;
    private  List<Contact> contactList;
    private static String mFileName;

    public static RepositoryCrud getInstance() {
        if (crudRealization == null) {
            crudRealization = new CrudRealization();

        }
        return crudRealization;
    }

    private CrudRealization() {
        this.contactList = new ArrayList<>();

    }

    @Override
    public List<Contact> getList() {
        return contactList;
    }

    @Override
    public Contact findById(int id) {

        return isValidIndex(id) ? contactList.get(id) : null;

    }

    @Override
    public void add(Contact contact) {

        if (contact != null) {
            contactList.add(contact);
        }
    }

    @Override
    public boolean remove(int id) {
        if (isValidIndex(id)) {
            contactList.remove(id);
            return true;
        } else
            return false;
    }

    private int returnId(Contact contact) {

        for (int i = 0; i < getList().size(); i++) {
            if (getList().get(i).equals(contact)) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(Contact contact) {
        return remove(returnId(contact));
    }

    @Override
    public int count() {
        return contactList.size();
    }

    @Override
    public boolean isEmpty() {
        return contactList.isEmpty();
    }

    @Override
    public List<Contact> search(String searchQuery) {


        String pattern = "^.*\\w*((?i)" + searchQuery + "(?-i))\\w*.*$";

        Pattern r = Pattern.compile(pattern);


        if (!getList().isEmpty()) {
            return getList().stream().filter(s ->( s.getName().matches(pattern) || s.getValueOfFieldName("surname").matches(pattern) )|| s.getPhoneNumber().matches(pattern)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public void setFileName(String fileName) {
        mFileName= fileName;

        try
        {

           contactList = (List<Contact>) DataSerialization.deserialize(mFileName);

        } catch (ClassNotFoundException | IOException ignored) {

        }
    }

    @Override
    public void serialize() throws IOException {
        if (mFileName != null) {

            DataSerialization.serialize(contactList,mFileName);

        }

    }

    private boolean isValidIndex(int id) {
        return (id >= 0 && id < contactList.size());
    }
}
