import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _5DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, HashSet<String>> typeMap = new LinkedHashMap<>();
        Map<String, int[]> skillMap = new TreeMap<>();

        int dragonCount = Integer.parseInt(br.readLine());

        while (dragonCount-- > 0) {
            String[] commands = br.readLine().split(" ");

            String type = commands[0];
            String name = commands[1];
            int[] currDragonSkills = new int[3];
            currDragonSkills[0] = commands[2].equals("null")
                    ? 45 : Integer.parseInt(commands[2]);
            currDragonSkills[1] = commands[3].equals("null")
                    ? 250 : Integer.parseInt(commands[3]);
            currDragonSkills[2] = commands[4].equals("null")
                    ? 10 : Integer.parseInt(commands[4]);

            if (!typeMap.containsKey(type)) {
                typeMap.put(type, new HashSet<>());
            }

            typeMap.get(type).add(name);

            skillMap.put(name, currDragonSkills);

        }
        for (Map.Entry<String, HashSet<String>> entry : typeMap.entrySet()) {
            int totalDamage = 0;
            int totalHealth = 0;
            int totalArmor = 0;
            double count =0;

            for (String s : entry.getValue()) {
                totalDamage += skillMap.get(s)[0];
                totalHealth += skillMap.get(s)[1];
                totalArmor += skillMap.get(s)[2];
                count++;
            }

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(),
                    totalDamage / count, totalHealth / count, totalArmor / count);

            entry.getValue().forEach(x->{
                int [] sk = skillMap.get(x);
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                        x, sk[0],sk[1], sk[2]);
            });
        }
    }
}
