package challanges;

import java.util.*;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/journey-to-the-moon/problem
 *
 */
public class JourneyToTheMoon {

    static int journeyToMoon(int n, int[][] astronautPairs) {
        if (astronautPairs.length == 0) {
            return countAllPossiblePairs(n);
        }
        int countOfUniqueAstronauts = getCountOfUniqueAstronauts(astronautPairs);
        int countOfAstronautsWithoutPair = n - countOfUniqueAstronauts;
        int countOfPairsOfAstronautsFromDifferentCountries = countAllPossiblePairs(countOfAstronautsWithoutPair);
        int pairsFormPairs = countAllPossiblePairsInPairs(astronautPairs.length - (astronautPairs.length * 2 - countOfUniqueAstronauts));
        return pairsFormPairs + countOfPairsOfAstronautsFromDifferentCountries + countOfAstronautsWithoutPair * countOfUniqueAstronauts;
    }

    private static int countAllPossiblePairs(int amountOfAstronauts) {
        return IntStream.range(1, amountOfAstronauts)
                .map(index -> amountOfAstronauts - index)
                .sum();
    }

    private static int countAllPossiblePairsInPairs(int pairsCount) {
        int astronautsCount = pairsCount * 2;
        return IntStream.range(1, pairsCount)
                .map(index -> (astronautsCount - index * 2) * 2)
                .sum();
    }

    private static int getCountOfUniqueAstronauts(int[][] pairs) {
        Set<Integer> astronauts = new HashSet<>();
        Arrays.stream(pairs).forEach(p -> {
            astronauts.add(p[0]);
            astronauts.add(p[1]);
        });
        return astronauts.size();
    }


}
