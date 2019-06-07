import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class _21AdvertisementMessage {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] phrases = new String[]{"Excellent product.", "Such a great product.",
                "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can't live without this product."};

        String []  events = new String[]{"Now I feel good.", "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.", "I feel great!"};


        String [] author = new String [] {"Diana", "Petya", "Stella", "Elena",
                "Katya", "Iva", "Annie", "Eva"};

        String [] cities = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random rand = new Random();
        int r = rand.nextInt();

        System.out.printf("%s %s %s – %s.",phrases[r%phrases.length]
                ,events[r%events.length],author[r%author.length],cities[r%cities.length]);


    }
}
