package app.util;

import java.io.*;

public class HtmlReaderImpl implements HtmlReader {
    @Override
    public String readHtmlFile(String htmlFilePath) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(new File(htmlFilePath))));

        StringBuilder htmlFileContent = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null && line.length() > 0) {
            htmlFileContent.append(line)
                    .append(System.lineSeparator());
        }

        return htmlFileContent.toString().trim();
    }
}
