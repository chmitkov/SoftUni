package appCats.util;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface HtmlReader {

    String readHTML(String htmlFilePath) throws IOException;

}
