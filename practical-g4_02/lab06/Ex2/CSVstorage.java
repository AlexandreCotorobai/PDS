import java.io.*;
import java.util.Collections;
import java.util.List;

public class CSVstorage implements ContactsStorageInterface{
    private String filename;
    public CSVstorage(String filename){
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<Contact> loadContacts(){
        List<Contact> tempList = new java.util.ArrayList<>(Collections.emptyList());
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                tempList.add(new Contact(arr[0], arr[1]));
            }
            br.close();
        } catch (IOException e){
            System.out.println("Something went wrong while reading the File.");
            e.printStackTrace();
        }
        return tempList;
    }

    public boolean saveContacts(List<Contact> list){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false)); // False = Overwrite
            for (Contact element: list) {
                String[] arr = element.toString().split("\t");
                writer.write(arr[0] + "," + arr[1]);
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}