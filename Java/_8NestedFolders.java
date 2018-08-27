import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class _8NestedFolders {
    public static void main(String[] args) {
        File root = new File("C:\\TestFolder\\Files-and-Streams");

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);
        int count = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                }
            }
            count++;
            System.out.println(current.getName());
        }
        System.out.printf("%d folders", count);
    }

}

