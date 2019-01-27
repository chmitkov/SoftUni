import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p08_SimpleTextEditor {
    private static StringBuilder text = new StringBuilder();
    private static ArrayDeque<String> commandsStack = new ArrayDeque<>();
    private static ArrayDeque<String> erasedStrings = new ArrayDeque<>();
    private static ArrayDeque<String> history = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int counter = Integer.parseInt(br.readLine());


        while (counter-- > 0) {
            String[] commands = br.readLine().split("\\s+");

            editText(commands);

        }
    }

    private static void editText(String[] commands) {
        int currentCommand = Integer.parseInt(commands[0]);
        if (currentCommand == 1 || currentCommand == 2) {
            commandsStack.push(String.join(" ", commands));
        }
        switch (currentCommand) {
            case 1:
                text.append(commands[1]);
                history.push(text.toString());
                break;
            case 2:
                erasedStrings.push(text.substring(text.length() - Integer.valueOf(commands[1])));
                text = new StringBuilder(text.substring(0, text.length() - Integer.valueOf(commands[1])));
                history.push(text.toString());
                break;
            case 3:
                System.out.println(text.charAt(Integer.valueOf(commands[1]) - 1));
                break;
            case 4:
                if (history.size() > 0) {
                    history.pop();
                }

                text = new StringBuilder(history.size() > 0
                        ? history.peek() : "");
                //undoCommands();
                break;
        }
    }

    private static void undoCommands() {
        String[] commandForUndo = commandsStack.pop().split("\\s+");
        int command = Integer.parseInt(commandForUndo[0]);
        switch (command) {
            case 1:
                text = new StringBuilder(text.substring(0, commandForUndo[1].length() - 1));
                break;
            case 2:
                text.append(erasedStrings.pop());
                break;
        }
    }
}
