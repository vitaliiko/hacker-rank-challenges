package challanges;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PairsTest {

    private void assertPairsResult(int targetValue, int[] integers, int expectedResult) {
        assertEquals(Pairs.pairs(targetValue, integers), expectedResult);
    }

    @Test
    public void testPairs() {
        assertPairsResult(1, new int[] {1, 5, 3, 4, 2}, 4);
        assertPairsResult(2, new int[] {1, 5, 3, 4, 2}, 3);
        assertPairsResult(0, new int[] {1, 5, 3, 4, 2}, 0);
        assertPairsResult(6, new int[] {1, 5, 3, 4, 2}, 0);
        assertPairsResult(2, new int[] {1, 3, 5, 8, 6, 4, 2}, 5);
        assertPairsResult(1, new int[] {363374326, 364147530, 61825163, 1073065718, 1281246024, 1399469912, 428047635, 491595254, 879792181, 1069262793}, 0);

        int size = (int) Math.pow(10, 5);
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = i;
        }

        System.out.println(LocalDateTime.now());
        assertPairsResult(1, numbers, size - 1);
        System.out.println(LocalDateTime.now());

    }

}
