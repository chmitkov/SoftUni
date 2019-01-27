import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class p05_Robotics {
    public static ArrayDeque<Robot> robots = new ArrayDeque<>();
    public static ArrayDeque<String> products = new ArrayDeque<>();
    public static StringBuilder sb = new StringBuilder();
    public static int localTime = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] robotsInput = reader.readLine().split(";");

        for (int i = 0; i < robotsInput.length; i++) {
            String[] robotTokens = robotsInput[i].split("-");
            Robot robot = new Robot();
            robot.name = robotTokens[0];
            robot.timeToProcess = Integer.parseInt(robotTokens[1]);
            robots.addLast(robot);
        }
        String[] timeInput = reader.readLine().split(":");
        localTime = Integer.parseInt(timeInput[0]) * 3600 + Integer.parseInt(timeInput[1]) * 60 + Integer.parseInt(timeInput[2]);
        for (Robot robot : robots) {
            robot.finishingTime = localTime;
        }
        localTime++;
        while (true) {
            String productName = reader.readLine();
            if ("end".equalsIgnoreCase(productName)) {
                break;
            }
            boolean isProcessed = false;
            for (Robot robot : robots) {
                if (localTime >= robot.finishingTime) {
                    isProcessed = true;
                    robot.finishingTime = localTime + robot.timeToProcess;
                    String time = convertTimeToString(localTime);
                    sb.append(String.format("%s - %s [%s]%n", robot.name, productName, time));
                    localTime++;
                    break;
                }
            }
            if (!isProcessed) {
                products.addLast(productName);
                localTime++;
            }
        }
        while (!products.isEmpty()) {
            processProduct();
        }
        System.out.print(sb);
    }

    public static String convertTimeToString(int localTime) {
        StringBuilder sb1 = new StringBuilder();
        int hours = (localTime / 3600) % 24;
        int timeLeft = localTime % 3600;
        int minutes = timeLeft / 60;
        int seconds = timeLeft % 60;
        sb1.append(addTimeElement(hours)).append(":");
        sb1.append(addTimeElement(minutes)).append(":");
        sb1.append(addTimeElement(seconds));
        return sb1.toString();
    }

    public static StringBuilder addTimeElement(int time) {
        StringBuilder sb1 = new StringBuilder();
        if (time < 10) {
            sb1.append("0").append(time);
        } else {
            sb1.append(time);
        }
        return sb1;
    }

    public static void processProduct() {
        boolean isProcessed = false;
        for (Robot robot : robots) {
            if (!products.isEmpty()) {
                if (localTime >= robot.finishingTime) {
                    robot.finishingTime = localTime + robot.timeToProcess;
                    isProcessed = true;
                    String time = convertTimeToString(localTime);
                    sb.append(String.format("%s - %s [%s]%n", robot.name, products.pollFirst(), time));
                    localTime++;
                }
            } else {
                break;
            }
        }
        if (!isProcessed) {
            products.addLast(products.pollFirst());
            localTime++;
        }
    }
}

class Robot {
    public String name;
    public int timeToProcess;
    public int finishingTime;
}