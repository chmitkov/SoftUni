package defineBankAccountClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, BankAccount> map = new HashMap<>();
        String line = br.readLine();

        while (!"End".equals(line)) {
            String[] commands = line.split("\\s+");
            String command = commands[0];
            int id = Integer.parseInt(commands[1]);
            switch (command) {
                case "Create":
                    if (map.containsKey(id)) {
                        System.out.println("Account already exists");
                    } else {
                        BankAccount currAcc = new BankAccount();
                        currAcc.setId(id);
                        map.put(id, currAcc);
                    }
                    break;
                case "Deposit":
                    int amount = Integer.parseInt(commands[2]);
                    if (!map.containsKey(id)){
                        System.out.println("Account does not exist");
                    }else{
                        map.get(id).deposit(amount);
                    }
                    break;
                case "Withdraw":
                    int amount1 = Integer.parseInt(commands[2]);
                    if (!map.containsKey(id)){
                        System.out.println("Account does not exist");
                    }else{
                        map.get(id).withdraw(amount1);
                    }
                    break;
                case "Print":
                        map.get(id).print();
                    break;
            }
            line = br.readLine();
        }

    }
}
