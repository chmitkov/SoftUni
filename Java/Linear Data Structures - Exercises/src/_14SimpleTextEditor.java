import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _14SimpleTextEditor {
    public static void main (String [] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        ArrayDeque<String> stack = new ArrayDeque<>();
        while (n-->0){
            String [] commands = br.readLine().split(" ");


            switch (commands[0]){

                case "1":
                    for (int i = 0; i < commands[1].length() ; i++) {
                        list.add(commands[1].charAt(i)+"");
                    }
                    stack.push(String.format("add-%s",commands[1]));
                    break;
                case "2":
                    int counter = Integer.parseInt(commands[1]);
                    String strToRemove = "";
                    while (counter-->0){
                        strToRemove+=list.get(list.size()-1);
                        list.remove(list.size()-1);
                    }

                    stack.push(String.format("dell-%s",new StringBuilder(strToRemove)
                            .reverse().toString()));
                    break;
                case "3":
                    int num1 = Integer.valueOf(commands[1]);
                    System.out.println(list.get(num1-1));
                    break;
                case "4":
                    String [] command = stack.pop().split("-");

                    if ("add".equals(command[0])){
                        for (int i = command[1].length()-1; i >=0 ; i--) {
                            list.remove(i);
                        }
                    }else{
                        for (int i = 0; i < command[1].length(); i++) {
                            list.add(command[1].charAt(i)+"");
                        }
                    }

                    break;
            }
        }
    }
}
