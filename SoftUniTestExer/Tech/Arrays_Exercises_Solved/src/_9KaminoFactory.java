import java.util.Arrays;
import java.util.Scanner;

public class _9KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] bestDNA = new int[n];
        String input = scanner.nextLine();
        int sampleCounter = 0;
        int bestSample = 0;
        while (!input.equals("Clone them!")) {
            int[] currentDNA = Arrays.stream(input.split("!"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            sampleCounter++;
            if (IsBetter(currentDNA, bestDNA)) {
                bestDNA = currentDNA;
                bestSample = sampleCounter;
            }
            if (bestSample == 0) {
                bestDNA = currentDNA;
                bestSample = sampleCounter;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n"
                , bestSample, Arrays.stream(bestDNA).sum());
        Arrays.stream(bestDNA).forEach(x -> System.out.printf("%d ", x));
    }

    private static boolean IsBetter(int[] currentDNA, int[] bestDNA) {
        if (dnaStats(currentDNA)[0] > dnaStats(bestDNA)[0]) {
            return true;
        } else if (dnaStats(currentDNA)[0] == dnaStats(bestDNA)[0]) {
            if (dnaStats(currentDNA)[1] < dnaStats(bestDNA)[1]) {
                return true;
            } else if (dnaStats(currentDNA)[1] == dnaStats(bestDNA)[1]) {
                if (dnaStats(currentDNA)[2] > dnaStats(bestDNA)[2]) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static int[] dnaStats(int[] currentDNA) {
        int bestLength = 0;
        int bestIndex = 0;
        int counter = 0;
        int bestSum = 0;
        int endIndex = 0;
        for (int i = 0; i < currentDNA.length; i++) {
            if (currentDNA[i] == 1) {
                bestSum++;
                counter++;
                if (counter > bestLength) {
                    bestLength = counter;
                    endIndex = i;
                }
            } else {
                counter = 0;
            }
        }
        bestIndex = endIndex - bestLength + 1;
        return new int[]{bestLength, bestIndex, bestSum};
    }
}

