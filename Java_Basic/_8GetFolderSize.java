import java.io.File;

public class _8GetFolderSize {
    public static void main(String[] args) {

        File file = new File("C:\\TestFolder\\Exercises Resources");
        long sum = 0L;
        if (file.isDirectory() && file.exists()) {
            File[] files = file.listFiles();
            for (File f : files) {
                sum+=f.length();
            }
        }
        System.out.printf("Folder size: %d",sum);
    }
}
