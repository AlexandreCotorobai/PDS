import java.util.List;

public class ContactApp implements ContactsInterface{
    private List<Contact> ContactList = null;
    private boolean saved = true;
    private ContactsStorageInterface CurrentStore = null;

    public ContactApp() {
    }

    @Override
    public void openAndLoad(ContactsStorageInterface store) {
        if (!saved) {
            System.out.println("You have unsaved changes, are you sure you want to load a new Contact List? Y/N");
            String input = System.console().readLine();
            if (input.equals("N")) {
                return;
            }
        }
        ContactList = store.loadContacts();
        CurrentStore = store;
        saved = true;
    }

    @Override
    public void saveAndClose() {
        if (storeNotExists(CurrentStore)) {
            System.out.println("No storage has been opened, please open a storage first.");
            return;
        }
        if (ContactList == null) {
            System.out.println("Warning: Empty contact list being saved.");
        }
        boolean success = CurrentStore.saveContacts(ContactList);
        if (!success) {
            System.out.println("Something went wrong while saving the file.");
        }
        saved = true;
        ContactList = null;
        CurrentStore = null;
    }

    @Override
    public void saveAndClose(ContactsStorageInterface store) {
        if (ContactList == null) {
            System.out.println("Warning: Empty contact list being saved.");
        }
        boolean success = store.saveContacts(ContactList);
        if (!success) {
            System.out.println("Something went wrong while saving the file.");
        }
        saved = true;
        ContactList = null;
        CurrentStore = null;
    }

    @Override
    public boolean exists(Contact contact) {
        if (storeNotExists(CurrentStore)) {
            System.out.println("No storage has been opened, please open a storage first.");
            return false;
        }
        return ContactList.contains(contact);
    }

    @Override
    public Contact getByName(String name) {
        if (storeNotExists(CurrentStore)) {
            System.out.println("No storage has been opened, please open a storage first.");
            return null;
        }
        for (Contact element: ContactList) {
            if (element.getName().equals(name)) {
                return element;
            }
        }
        return null;
    }

    @Override
    public boolean add(Contact contact) {
        if (storeNotExists(CurrentStore)) {
            System.out.println("No storage has been opened, please open a storage first.");
            return false;
        }

        if (exists(contact)) {
            System.out.println("Contact " + contact.toString() + " already exists, if you wish to change/remove it use remove() first.");
            return false;
        }

        ContactList.add(contact);
        saved = false;
        return true;
    }

    @Override
    public boolean remove(Contact contact) {
        if (storeNotExists(CurrentStore)) {
            System.out.println("No storage has been opened, please open a storage first.");
            return false;
        }

        if (!exists(contact)) {
            return false;
        }
        ContactList.remove(contact);
        saved = false;
        return true;
    }

    private boolean storeNotExists(ContactsStorageInterface store) {
        return store == null;
    }
}
