public class ContactMain {
    public static void main(String[] args) {
        ContactsInterface App = new ContactApp();
        ContactsStorageInterface TXTstore = new TXTstorage("contacts.txt");
        ContactsStorageInterface BINstore = new BINstorage("contacts.bin");
        ContactsStorageInterface JSONstore = new JSONstorage("contacts.json");
        ContactsStorageInterface CSVstore = new CSVstorage("contacts.csv");

        /*
         * The following code will create a bin file with 3 contacts
         */

        App.openAndLoad(TXTstore);
        App.add(new Contact("John", "123456789"));
        App.add(new Contact("Jane", "987654321"));
        App.add(new Contact("Doey", "123456789"));
        App.saveAndClose(BINstore); // convert into BIN

        /*
         * The following code will remove the contact "Doey"
         * and add a new contact "Tester"
         * and save the changes to the bin file
         */

        App.openAndLoad(BINstore);
        App.remove(new Contact("Doey", "123456789"));
        App.add(new Contact("Tester", "412412312"));
        App.saveAndClose(); // save to bin file

        /*
         * The following code will open the bin file
         * remove the contact "John"
         * and save the changes to the CSV file
         */

        App.openAndLoad(BINstore);
        App.remove(new Contact("John", "123456789"));
        App.saveAndClose(CSVstore); // convert into CSV

        /*
         * The following code will open the CSV file
         * remove the contact "Jane"
         * and save the changes to the TXT file
         */
        App.openAndLoad(CSVstore);
        App.remove(new Contact("Jane", "987654321"));
        App.saveAndClose(TXTstore); // convert into TXT


        /*
         * Uncomment the following lines to test the JSONstorage
         * Requires the JSON-simple library
         * Check the README.md for more info
         */

       /* 
        App.openAndLoad(JSONstore);
        App.add(new Contact("John", "123456789"));
        App.add(new Contact("Jane", "987654321"));
        App.add(new Contact("Doey", "123456789"));
        App.saveAndClose();

        App.openAndLoad(JSONstore);
        App.remove(new Contact("Doey", "123456789"));
        App.saveAndClose(CSVstore);
        */

    }
}
