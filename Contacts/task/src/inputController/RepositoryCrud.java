package inputController;
import domain.Contact;

import java.io.IOException;
import java.util.List;

public interface RepositoryCrud {
    List<Contact> getList();
    Contact findById(int id);
    void add(Contact contact);
    boolean remove(int id);
    boolean remove(Contact contact);
    int count();
    boolean isEmpty();
    List<Contact> search(String searchQuery);
    void serialize() throws IOException;
    void setFileName(String fileName);

}
