package challanges;

import java.util.stream.IntStream;

public class JourneyToTheMoon {

    static int journeyToMoon(int n, int[][] astronautPairs) {
        if (astronautPairs.length == 0) {
            return countAllPossiblePairs(n);
        }
        int countOfAstronautsWithoutPair = n - astronautPairs.length * 2;
        int countOfPairsOfAstronautsFromDifferentCountries = countAllPossiblePairs(countOfAstronautsWithoutPair);
        int pairsFormPairs = countAllPossiblePairsInPairs(astronautPairs.length);
        return pairsFormPairs + countOfPairsOfAstronautsFromDifferentCountries + countOfAstronautsWithoutPair * astronautPairs.length * 2;
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


}
