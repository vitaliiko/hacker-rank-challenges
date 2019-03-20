package challanges;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/pairs/problem
 *
 */
public class Pairs {

    static int pairs(int targetValue, int[] integers) {
        int counter = 0;
        int[] sortedIntegers = Arrays.stream(integers).sorted().toArray();
        for (int i = 0; i < sortedIntegers.length - 1; i++) {
            int matchingValue = sortedIntegers[i] + targetValue;
            for (int j = i + 1; j < sortedIntegers.length; j++) {
                if (sortedIntegers[j] == matchingValue) {
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }

}
