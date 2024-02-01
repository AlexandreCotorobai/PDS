import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path> {
    private int recursiveLevel = 0;
    private boolean recursive = false;
    private Long totalSize = 0L;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        // get the file nam
        String fileName = file.getFileName().toString();
        // get file size
        long fileSize = attrs.size();

        totalSize += fileSize;
        System.out.println(" ".repeat(recursiveLevel) + "|->" + fileName + ": " + fileSize + " bytes");
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        if (!recursive && recursiveLevel > 0) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        // get the directory name
        String dirName = dir.getFileName().toString();
        if(recursiveLevel >= 1)
        {
            System.out.println(" ".repeat(recursiveLevel) + "|->" + dirName + " (directory)");
        } else
        {
            System.out.println(dirName + " (root directory)");
        }   
        recursiveLevel++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, java.io.IOException exc) {
        System.out.println("Failed to visit: " + file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, java.io.IOException exc) {
        recursiveLevel--;
        if (recursiveLevel == 0) {
            System.out.println("Total size: " + totalSize + " bytes");
        }
        return FileVisitResult.CONTINUE;
    }

    public MyFileVisitor(Boolean bool) {
        super();
        this.recursive = bool;
    }


}
