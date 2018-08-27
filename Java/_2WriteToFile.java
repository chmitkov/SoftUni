import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class _2WriteToFile {
    public static void main(String[] args) {
        String inputPath = "C:\\TestFolder\\input.txt";
        String outputPath = "C:\\TestFolder\\output.txt";
        Set <Character> set = new HashSet<>();
        Collections.addAll(set,',','.','!','?');
        try(FileInputStream inputStream = new FileInputStream(inputPath);
            FileOutputStream outputStream = new FileOutputStream(outputPath)){
            int oneByte = inputStream.read();
            while (oneByte>=0){
                if(!set.contains((char)oneByte)){
                    outputStream.write(oneByte);
                }
                oneByte = inputStream.read();
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
