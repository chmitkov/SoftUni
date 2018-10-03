import java.util.Arrays;
        import java.util.Scanner;

public class _10LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] ladyBugs = new int[fieldSize];
        for (int i = 0; i < indexes.length; i++)
        {
            if (indexes[i] >= 0 && indexes[i] < ladyBugs.length)
            {
                ladyBugs[indexes[i]] = 1;
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("end"))
        {
            String[] commands = input.split(" ");

            int ladyIndex = Integer.parseInt(commands[0]);
            String direction = commands[1];
            int flightLength = Integer.parseInt(commands[2]);
            if (ladyIndex >= 0 && ladyIndex < ladyBugs.length
                    && ladyBugs[ladyIndex] != 0)
            {
                ladyBugs[ladyIndex] = 0;
                if (direction.equals("right"))
                {
                    int endIndex = ladyIndex + flightLength;
                    while (endIndex < ladyBugs.length)
                    {
                        if (ladyBugs[endIndex] == 0)
                        {
                            ladyBugs[endIndex] = 1;
                            break;
                        }
                        else
                        {
                            endIndex += flightLength;
                        }
                    }
                }
                else
                {
                    int endIndex = ladyIndex - flightLength;
                    while (endIndex >= 0)
                    {
                        if (ladyBugs[endIndex] == 0)
                        {
                            ladyBugs[endIndex] = 1;
                            break;
                        }
                        else
                        {
                            endIndex -= flightLength;
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        Arrays.stream(ladyBugs).forEach(x-> System.out.printf("%d ",x));
    }
}

