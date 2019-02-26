import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p10_PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(br.readLine().split("\\s+"))
                .collect(Collectors.toList());

        String line;

        while (!"Party!".equalsIgnoreCase(line = br.readLine())) {
            String[] commands = line.split("\\s+");
            if ("Remove".equalsIgnoreCase(commands[0])) {
                switch (commands[1]) {
                    case "StartsWith":
                        String ch = commands[2];
                        names = names.stream()
                                .filter(x -> !x.startsWith(ch))
                                .collect(Collectors.toList());
                        break;
                    case "EndsWith":
                        String endCh = commands[2];
                        names = names.stream()
                                .filter(x -> !x.endsWith(endCh))
                                .collect(Collectors.toList());
                        break;
                    case "Length":
                        int length = Integer.parseInt(commands[2]);
                        names = names.stream()
                                .filter(x -> x.length() != length)
                                .collect(Collectors.toList());
                        break;
                }
            } else {
                switch (commands[1]) {
                    case "StartsWith":
                        String ch = commands[2];
                        for (int i = 0; i < names.size(); i++) {
                            if (names.get(i).startsWith(ch)) {
                                names.add(i + 1, names.get(i));
                            }
                            i++;

                        }
                        break;
                    case "EndsWith":
                        String endCh = commands[2];
                        for (int i = 0; i < names.size(); i++) {
                            if (names.get(i)
                                    .endsWith(endCh)) {
                                names.add(i + 1, names.get(i));
                            }
                            i++;
                        }
                        break;
                    case "Length":
                        int length = Integer.parseInt(commands[2]);
                        for (int i = 0; i < names.size(); i++) {
                            if (names.get(i).length() == length) {
                                names.add(i + 1, names.get(i));
                            }
                            i++;
                        }
                        break;
                }
            }
        }
        System.out.println(names.isEmpty()
                ? "Nobody is going to the party!"
                : String.format("%s are going to the party!",
                String.join(", ", names)));
    }
}
