package problem_4_Telephony;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class Smartphone implements Callable, Browsable {
    private ArrayList<String> numbers;
    private ArrayList<String> sites;

    public Smartphone(ArrayList numbers, ArrayList sites) {
        this.numbers = numbers;
        this.sites = sites;
    }

    @Override
    public String callTo() {
        StringBuilder sb = new StringBuilder();
        for (String num : numbers) {
            if (num.matches("[^0-9]")) {
                sb.append("IInvalid number!%n");
            }else{
                sb.append(String.format("Calling... %s%n", num));
            }
        }
        return sb.toString();
    }

    @Override
    public String browseIn() {
        StringBuilder sb = new StringBuilder();
        for (String site : sites) {
            if (site.matches(".*\\d+.*")) {
                sb.append("Invalid URL!");
            }else{
                sb.append(String.format("Browsing: %s!%n", site));
            }
        }
        return sb.toString();
    }
}
