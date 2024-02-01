import java.io.*;
import java.util.Collections;
import java.util.List;

public class BINstorage implements ContactsStorageInterface{
    private String filename;
    public BINstorage(String filename){
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
            File fileObj = new File(filename);
            if (!fileObj.exists()) {
                return tempList;
            }
            FileInputStream fis = new FileInputStream(fileObj);
            int ch;
            StringBuilder line = new StringBuilder();
            while ((ch = fis.read()) != -1) {
                if (ch == 10) {
                    String[] arr = line.toString().split("\t");
                    tempList.add(new Contact(arr[0], arr[1]));
                    line = new StringBuilder();
                } else {
                    line.append((char) ch);
                }
            }
            fis.close();
        } catch (IOException e){
            System.out.println("Something went wrong while reading the File.");
            e.printStackTrace();
        }
        return tempList;
    }

    public boolean saveContacts(List<Contact> list){
        try {
            FileOutputStream fos = new FileOutputStream(filename, false); // False = Overwrite
            for (Contact element: list) {
                for (byte b: element.toString().getBytes()) {
                    fos.write(b);
                }
                fos.write(10);
            }
            fos.flush();
            fos.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}