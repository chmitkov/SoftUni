package bookshopsystemapp.util;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileUtil {

    String [] getFileContent(String filePath) throws IOException;
}
