package challanges;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SherlockAndArrayTest {

    private void assertBalancedSums(String expectedResult, int ...arrayElements) {
        List<Integer> numbers = Arrays.stream(arrayElements).boxed().collect(Collectors.toList());
        assertEquals(SherlockAndArray.balancedSums(numbers), expectedResult);
    }

    @Test
    void givenEmptyArray_returnsNo() {
        assertBalancedSums("NO");
    }

    @Test
    void givenOneElementArray_returnsYes() {
        assertBalancedSums("YES", 0);
        assertBalancedSums("YES", 1);
        assertBalancedSums("YES", 2);
    }

    @Test
    void givenArrayWithTwoElements_returnsNo() {
        assertBalancedSums("NO", 1, 1);
        assertBalancedSums("NO", 1, 3);
        assertBalancedSums("NO", 5, 1);
    }

    @Test
    void givenArrayWithOneNonZeroElements_returnsYes() {
        assertBalancedSums("YES", 1, 0);
        assertBalancedSums("YES", 0, 1);
        assertBalancedSums("YES", 0, 2, 0, 0);
        assertBalancedSums("YES", 0, 0, 0, 2);
        assertBalancedSums("YES", 2, 0, 0, 0);
    }

    @Test
    void givenArrayWithFirstElementEqualsSumOfOthersExceptSecond_returnsYes() {
        assertBalancedSums("YES", 11, 5, 7, 4);
        assertBalancedSums("YES", 7, 5, 7, 0);
        assertBalancedSums("YES", 17, 5, 7, 1, 5, 2, 2);
        assertBalancedSums("YES", 17, 0, 7, 10);
    }

    @Test
    void givenArrayWithLastElementEqualsSumOfOthersExceptPenult_returnsYes() {
        assertBalancedSums("YES", 2, 3, 4, 5);
        assertBalancedSums("YES", 5, 7, 1, 2, 0, 15);
        assertBalancedSums("YES", 0, 0, 5, 12, 5);
    }

    @Test
    void givenBalancedArray_returnsYes() {
        assertBalancedSums("YES", 5, 7, 1, 2, 10, 7, 8);
        assertBalancedSums("YES", 5, 9, 1, 2, 0, 7, 8);
        assertBalancedSums("YES", 1, 1, 4, 1, 1);
    }

    @Test
    void givenNotBalancedArray_returnsNo() {
        assertBalancedSums("NO", 5, 9, 1, 2, 10, 7, 8);
        assertBalancedSums("NO", 5, 10, 1, 2, 0, 7, 8);
    }
}
