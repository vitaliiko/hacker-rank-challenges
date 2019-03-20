package challanges;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-array/problem
 *
 */
public class SherlockAndArray {

    static String balancedSums(List<Integer> arr) {
        if (arr.size() == 1) {
            return "YES";
        }

        for (int i = 0; i < arr.size(); i++) {
            int rightSum = arr.subList(i + 1, arr.size())
                    .stream()
                    .mapToInt(Integer::intValue).sum();

            int leftSum = arr.subList(0, i)
                    .stream()
                    .mapToInt(Integer::intValue).sum();

            if (rightSum == leftSum) {
                return "YES";
            }
        }

        return "NO";

    }

}
