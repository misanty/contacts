package inputController;
import domain.Contact;

import java.util.List;

public interface RepositoryCrud {
    List<Contact> getList();
    List<Contact> findById(int id);
    void add(Contact contact);
    boolean remove(int id);
    int count();
    boolean isEmpty();
    List<Contact> search(String searchQuery);
}
