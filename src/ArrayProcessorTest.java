import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayProcessorTest {
    @Test
    void testFindMax() {
        int[] array = {1, -5, 20, 3, -10};
        assertEquals(20, ArrayProcessor.findMax(array));
    }

    @Test
    void testCalculateProductBetweenNegatives() {
        int[] array = {1, -5, 2, 3, -10};
        assertEquals(6, ArrayProcessor.calculateProductBetweenNegatives(array));
    }

    @Test
    void testCalculateProductBetweenNegativesNoNegatives() {
        int[] array = {1, -5, 2, 3, -10};
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                ArrayProcessor.calculateProductBetweenNegatives(array));
        assertEquals("В масиві менше 2 відємних елементів.", exception.getMessage());
    }

}