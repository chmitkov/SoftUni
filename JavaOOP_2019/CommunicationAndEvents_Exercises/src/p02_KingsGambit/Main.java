package p02_KingsGambit;

import p02_KingsGambit.Models.Footman;
import p02_KingsGambit.Models.King;
import p02_KingsGambit.Models.RoyalGuard;
import p02_KingsGambit.Models.Soldier;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String,Soldier> soldiersByName = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);

        King king = new King(scanner.nextLine());
        String[] guards = scanner.nextLine().split(" ");
        for (String guardName : guards) {
            RoyalGuard newGuard = new RoyalGuard(guardName);
            soldiersByName.put(guardName, newGuard);
            king.addUnderAttackListener(newGuard);
        }
        String[] footmen = scanner.nextLine().split(" ");
        for (String footmanName : footmen) {
            Footman newFootman = new Footman(footmanName);
            soldiersByName.put(footmanName,newFootman);
            king.addUnderAttackListener(newFootman);
        }

        String line = scanner.nextLine();
        while(!line.equals("End")){
            String[] parameters = line.split(" ");
            switch(parameters[0]){
                case "Attack":
                    king.respondToAttack();
                    break;
                case "Kill":
                    Soldier soldierToRemove = soldiersByName.get(parameters[1]);
                    king.removeUnderAttackListener(soldierToRemove);
                    soldiersByName.remove(parameters[1]);
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
