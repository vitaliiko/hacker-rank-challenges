import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Challanges {

    static List<Integer> compareTriplets(List<Integer> aliceRate, List<Integer> bobRate) {
        int aliceScore = 0;
        int bobScore = 0;

        int index = 0;
        for (int rate : aliceRate) {
            if (rate > bobRate.get(index)) {
                aliceScore++;
            } else if (rate < bobRate.get(index)) {
                bobScore++;
            }
            index++;
        }

        return Arrays.asList(aliceScore, bobScore);
    }

    static long aVeryBigSum(long[] ar) {
        return Arrays.stream(ar).sum();

    }

    static int diagonalDifference(int[][] arr) {
        int leftToRight = 0;
        int rightToLeft = 0;
        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            leftToRight += arr[i][i];
            rightToLeft += arr[i][j];
        }
        return Math.abs(leftToRight - rightToLeft);
    }

    static int[] insertionSort1(int n, int[] arr) {
        int index = n - 1;
        int inserted = arr[index];
        index--;

        while (index >= 0 && arr[index] > inserted) {
            arr[index + 1] = arr[index];
            printArray(arr);
            index--;
        }
        arr[index + 1] = inserted;
        printArray(arr);
        return arr;
    }

    static void insertionSort2(int n, int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int subarrayLength = i + 2;
            int[] ints = insertionSort1(subarrayLength, Arrays.copyOfRange(arr, 0, subarrayLength));
            for (int j = 0; j < subarrayLength; j++) {
                arr[j] = ints[j];
            }
            printArray(arr);
        }
    }

    private static void printArray(int[] arr) {
        String transformationsResult = "";
        for (int element : arr) {
            transformationsResult += element + " ";
        }
        System.out.println(transformationsResult.trim());
    }

    static String isValid(String s) {
        if (s == null) return "NO";
        if ("".equals(s)) return "YES";

        Map<Character, Integer> charCounts = new HashMap<>();
        for (char character : s.toCharArray()) {
            Integer count = charCounts.get(character);
            count = count == null ? 1 : count + 1;
            charCounts.put(character, count);
        }

        List<Integer> counts = charCounts.values().stream().distinct().collect(Collectors.toList());
        if (counts.size() == 1) return "YES";
        if (counts.size() > 2) return "NO";

        List<Integer> shortest = charCounts.values().stream().filter(i -> i == 1).collect(Collectors.toList());
        if (shortest.size() == 1) return "YES";

        List<Integer> sorted = charCounts.values().stream().sorted().collect(Collectors.toList());
        int lastElementIndex = sorted.size() - 1;
        sorted.set(lastElementIndex, sorted.get(lastElementIndex) - 1);
        boolean allEqual = sorted.stream().allMatch(sorted.get(0)::equals);
        return allEqual ? "YES" : "NO";
    }
    
}
