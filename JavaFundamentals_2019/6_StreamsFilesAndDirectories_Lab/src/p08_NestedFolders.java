import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class p08_NestedFolders {
    public static void main(String[] args) {

        String path = "C:\\Users\\9999\\Desktop\\StreamsFilesAndDirectories_Lab\\" +
                "src\\resources\\Files-and-Streams";

        File root = new File(path);

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        int counter = 0;

        while (!dirs.isEmpty()){
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if(nestedFile.isDirectory()){
                    dirs.offer(nestedFile);
                    counter++;
                }
            }
            System.out.println(current.getName());
        }
        System.out.println(counter + " folders");
    }
}
