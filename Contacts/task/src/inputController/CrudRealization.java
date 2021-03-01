package inputController;

import domain.Contact;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class CrudRealization implements RepositoryCrud {

    private static CrudRealization crudRealization;
    private final List<Contact> contactList;

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
    public List<Contact> findById(int id) {

        return isValidIndex(id) ? List.of(contactList.get(id)) : Collections.emptyList();
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
        }
        else
            return false;
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
        /**
         * TODO here you should create a search using with regex which search for at the beginning, middle or end of the string of the related fields.
         *  You can try something like this https://stackoverflow.com/questions/24797857/java-filtering-list-entries-by-regex
         *  return the list then
         */
        return null;
    }

    private boolean isValidIndex(int id) {
        return (id >= 0 && id < contactList.size());
    }
}
