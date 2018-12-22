package alararestaurant.util;

import java.io.*;

public class FileUtilImpl implements FileUtil {

    @Override
    public String readFile(String filePath) throws IOException {
        StringBuilder resultString = new StringBuilder();

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(new File(filePath))));


        String line;

        while ((line=bufferedReader.readLine())!= null){
            resultString.append(line).append(System.lineSeparator());
        }

        return resultString.toString().trim();
    }
}
