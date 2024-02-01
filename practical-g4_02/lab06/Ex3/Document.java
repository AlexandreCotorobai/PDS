import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class Document {

    private final String fileName;
    public Document(String fileName) {
        this.fileName = fileName;
    }
    public String getFileName() {
        return fileName;
    }

    public String[] getContent() {
        List<String> lines = null;

        try{
            lines = Files.readAllLines( new File(fileName).toPath() );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines.toArray(new String[0]);
    }

    @Override
    public String toString() {
        String[] lines = getContent();
        StringBuilder content = new StringBuilder();
        content.append(lines[0], 0, Math.min(20, lines[0].length() - 1)).append("...");
        return content.toString();
    }
}
