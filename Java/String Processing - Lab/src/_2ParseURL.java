import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2ParseURL {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] urlArray = br.readLine().split("://");
        String protocol = urlArray[0];
        String server = "";
        String resources = "";
        if (urlArray.length == 2) {
            String restUrl = urlArray[1];
            server = restUrl.substring(0, restUrl.indexOf("/"));
            resources = restUrl.substring(restUrl.indexOf('/')+1);
            System.out.printf("Protocol = %s\n" +
                    "Server = %s\n" +
                    "Resources = %s",protocol,server,resources);
        } else {
            System.out.println("Invalid URL");
        }
    }
}
