import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p09_InfixToPostfix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        ArrayDeque<String> operatorStack = new ArrayDeque<>();
        ArrayDeque<String> outputQueue = new ArrayDeque<>();
        for (String token : tokens) {
            if (!"-+/*()".contains(token)) {
                outputQueue.offer(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.peek().equals("(")) {
                    outputQueue.offer(operatorStack.pop());
                }
                operatorStack.pop();
            } else {
                if ("-+".contains(token)) {
                    while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                        outputQueue.offer(operatorStack.pop());
                    }
                } else {
                    while (!operatorStack.isEmpty() && !"+-(".contains(operatorStack.peek())) {
                        outputQueue.offer(operatorStack.pop());
                    }
                }
                operatorStack.push(token);
            }
        }
        while (!operatorStack.isEmpty()) {
            outputQueue.offer(operatorStack.pop());
        }
        System.out.println(String.join(" ", outputQueue));
    }
}