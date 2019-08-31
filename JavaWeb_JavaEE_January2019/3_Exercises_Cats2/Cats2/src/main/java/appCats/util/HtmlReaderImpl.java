package appCats.util;

import java.io.*;

public class HtmlReaderImpl implements HtmlReader {

    @Override
    public String readHTML(String htmlFilePath) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File(htmlFilePath)
                        )));


        StringBuilder sb = new StringBuilder();

        String htmlFileLine;

        while ((htmlFileLine = br.readLine()) != null) {
            sb.append(htmlFileLine)
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
