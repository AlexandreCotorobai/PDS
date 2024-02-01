import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
/**
 * VisitorDemo
 */
public class VisitorDemo {

    public static void main(String[] args) {
        if (args.length > 2 || args.length < 1) {
            System.out.println("Usage: java VisitorDemo <optional-recursive> <path>");
            System.exit(-1);
        }

        boolean recursive = args.length == 2 ? true : false;
        String path = args.length == 2 ? args[1] : args[0];

        Path p = Paths.get(path);

        try {
            Files.walkFileTree(p, new MyFileVisitor(recursive));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}