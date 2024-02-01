import java.io.*;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONstorage implements ContactsStorageInterface{
    private String filename;
    public String getFilename() {
        return filename;
    }

    public JSONstorage(String filename){
        this.filename = filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<Contact> loadContacts(){
        System.out.println("Loading from file: "+filename);
        List<Contact> tempList = new java.util.ArrayList<>(Collections.emptyList());
        JSONParser parser = new JSONParser();
        try {
            File fileObj = new File(filename);
            if (!fileObj.exists()) {
                return tempList;
            }
            Reader reader = new FileReader(filename);
            JSONArray obj = (JSONArray) parser.parse(reader);
            for (Object element: obj.toArray()){
                JSONObject contact = (JSONObject) element;
                tempList.add(new Contact((String) contact.get("name"), (String) contact.get("number")));
            }
            reader.close();
        } catch (ParseException | IOException e) {
            System.out.println("Something went wrong while reading the File.");
            e.printStackTrace();
        }
        System.out.println("Loaded "+tempList.size()+" contacts.");
        return tempList;
    }

    public boolean saveContacts(List<Contact> list){
        try {
            Writer writer = new FileWriter(filename, false); // False = Overwrite
            JSONArray contacts = new JSONArray();
            for (Contact element: list) {
                JSONObject contact = new JSONObject();
                contact.put("name", element.getName());
                contact.put("number", element.getNum());
                contacts.add(contact);
            }
            writer.write(contacts.toJSONString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}