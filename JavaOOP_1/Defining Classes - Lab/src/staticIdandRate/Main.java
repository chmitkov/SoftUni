package staticIdandRate;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, BankAccount1> map = new HashMap<>();
        String line = br.readLine();

        while (!"End".equals(line)) {
            String[] commands = line.split("\\s+");
            String command = commands[0];

            switch (command) {
                case "Create":
                    BankAccount1 currAcc = new BankAccount1();
                    map.put(currAcc.getId(), currAcc);
                    System.out.printf("Account %s created%n", currAcc.toString());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(commands[1]);
                    int amount = Integer.parseInt(commands[2]);
                    if (map.containsKey(id)) {
                        map.get(id).deposit(amount);
                        System.out.printf("Deposited %d to %s%n", amount, map.get(id).toString());
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    int interest = Integer.parseInt(commands[1]);
                    BankAccount1.setInterest(interest);
                    break;
                case "GetInterest":
                    if (map.containsKey(Integer.parseInt(commands[1]))){
                        int currId = Integer.parseInt(commands[1]);
                        int years = Integer.parseInt(commands[2]);
                        System.out.printf("%.2f%n",map.get(currId).getInterest(years));
                    }else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }


            line = br.readLine();
        }
    }
}
