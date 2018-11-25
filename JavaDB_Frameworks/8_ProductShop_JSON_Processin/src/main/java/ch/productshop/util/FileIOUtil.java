package ch.productshop.util;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileIOUtil {
    String readFile(String filePath) throws IOException;
}
