import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _16URLParser {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String server = "";
        String resource = "";
        String protocol = "";
        if (str.contains("://")) {
            protocol = str.substring(0, str.indexOf("://"));
            str = str.substring(str.indexOf("://") + 3);
        }

        if (str.contains("/")) {
            server = str.substring(0, str.indexOf("/"));
            resource = str.substring(str.indexOf("/")+1);
        } else {
            server = str;
        }
        System.out.printf("[protocol] = \"%s\"\n" +
                "[server] = \"%s\"\n" +
                "[resource] = \"%s\"",protocol,server,resource);


    }
}
