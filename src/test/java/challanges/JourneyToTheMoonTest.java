package challanges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JourneyToTheMoonTest {

    private int calculatePairsCount(int astronauts, int[][] pairs) {
        return JourneyToTheMoon.journeyToMoon(astronauts, pairs);
    }

    private int calculatePairsCount(int astronauts) {
        return JourneyToTheMoon.journeyToMoon(astronauts, new int[][]{});
    }

    @Test
    void givenZeroAstronauts_returnsZero() {
        assertEquals(calculatePairsCount(0), 0);
    }

    @Test
    void givenOneAstronaut_returnsZero() {
        assertEquals(calculatePairsCount(1), 0);
    }

    @Test
    void givenTwoAstronauts_returnsOne() {
        assertEquals(calculatePairsCount(2), 1);
    }

    @Test
    void givenThreeAstronauts_returnsThree() {
        assertEquals(calculatePairsCount(3), 3);
    }

    @Test
    void givenNumberOfAstronauts_returnsAllPossiblePairsNumber() {
        assertEquals(calculatePairsCount(4), 6);
        assertEquals(calculatePairsCount(10), 45);
    }

    @Test
    void givenTwoAstronautsAndOnePair_returnsZero() {
        int[][] pairs = {
            { 0, 1 }
        };
        assertEquals(calculatePairsCount(2, pairs), 0);
    }

    @Test
    void givenThreeAstronautsAndOnePair_returnsTwo() {
        int[][] pairs = {
            { 0, 1 }
        };
        assertEquals(calculatePairsCount(3, pairs), 2);
    }

    @Test
    void givenNAstronautsAndOnePair_returnsAllPossiblePairsCount() {
        int[][] pairs = {
            { 0, 1 }
        };
        assertEquals(calculatePairsCount(4, pairs), 5);
        assertEquals(calculatePairsCount(5, pairs), 9);
        assertEquals(calculatePairsCount(12, pairs), 65);
    }

    @Test
    void givenFourAstronautsAndTwoPairs_returnsFour() {
        int[][] pairs = {
            { 0, 1 },
            { 2, 3 },
        };
        assertEquals(calculatePairsCount(4, pairs), 4);
    }

    @Test
    void givenNAstronautsAndTwoPairs_returnsAllPossiblePairs() {
        int[][] pairs = {
            { 0, 1 },
            { 2, 3 },
        };
        assertEquals(calculatePairsCount(5, pairs), 8);
        assertEquals(calculatePairsCount(6, pairs), 13);
        assertEquals(calculatePairsCount(14, pairs), 89);
    }

    @Test
    void givenNAstronautsAndThreePairs_returnsAllPossiblePairs() {
        int[][] pairs = {
            { 0, 1 },
            { 2, 3 },
            { 4, 5 },
        };
        assertEquals(calculatePairsCount(6, pairs), 12);
        assertEquals(calculatePairsCount(7, pairs), 18);
        assertEquals(calculatePairsCount(16, pairs), 117);
    }

    @Test
    void givenThreeAstronautsAndTwoPairs_returnsZero() {
        int[][] pairs = {
            { 0, 1 },
            { 0, 2 },
        };
        assertEquals(calculatePairsCount(3, pairs), 0);
    }

    @Test
    void givenFourAstronautsAndTwoPairsFromOneCountry_returnsThree() {
        int[][] pairs = {
            { 0, 1 },
            { 0, 2 },
        };
        assertEquals(calculatePairsCount(4, pairs), 3);
    }

    @Test
    void givenNAstronautsAndTwoPairsFromOneCountry_returnsAllPossiblePairs() {
        int[][] pairs = {
            { 0, 1 },
            { 0, 2 },
        };
        assertEquals(calculatePairsCount(5, pairs), 7);
        assertEquals(calculatePairsCount(6, pairs), 12);
        assertEquals(calculatePairsCount(13, pairs), 75);
    }

    @Test
    void givenFourAstronautsAndThreePairs_returnsZero() {
        int[][] pairs = {
            { 0, 1 },
            { 0, 2 },
            { 0, 3 },
        };
        assertEquals(calculatePairsCount(4, pairs), 0);
    }

    @Test
    void givenNAstronautsAndThreePairsFromOneCountry_returnsAllPossiblePairs() {
        int[][] pairs = {
            { 0, 1 },
            { 0, 2 },
            { 0, 3 },
        };
        assertEquals(calculatePairsCount(5, pairs), 4);
        assertEquals(calculatePairsCount(14, pairs), 85);
    }
}
