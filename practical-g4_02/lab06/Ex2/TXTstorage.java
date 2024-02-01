import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class TXTstorage implements ContactsStorageInterface {
    private String filename;
    public TXTstorage(String filename){
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<Contact> loadContacts(){
        System.out.println("Loading from file: "+filename);
        List<Contact> tempList = new java.util.ArrayList<>(Collections.emptyList());
        try {
            File fileObj = new File(filename);
            if (!fileObj.exists()) {
                return tempList;
            }
            Scanner sc_reader = new Scanner(fileObj);
            while (sc_reader.hasNextLine()) {
                String line = sc_reader.nextLine().strip();
                String[] arr = line.split("\t");
                tempList.add(new Contact(arr[0], arr[1]));
            }
            sc_reader.close();
        } catch (IOException e){
            System.out.println("Something went wrong while reading the File.");
            e.printStackTrace();
        }
        System.out.println("Loaded "+tempList.size()+" contacts.");
        return tempList;
    }

    public boolean saveContacts(List<Contact> list){
        System.out.println("Saving to file: "+filename);
        try {
            Writer writer = new FileWriter(filename, false); // False = Overwrite
            for (Contact element: list) {
                writer.write(element.toString()+"\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}