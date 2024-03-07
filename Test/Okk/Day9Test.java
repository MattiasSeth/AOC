package Okkk;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Day1Test {

    @Test
    public void testCalculate() {
        Day1 d1 = new Day1();
        List<Integer> testList = new ArrayList<>(List.of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263));

        assertEquals(7,d1.problemOne(testList));
        assertEquals(5,d1.problemTwo(testList));

        assertNotEquals(7,d1.problemTwo(testList));
        assertNotEquals(5,d1.problemOne(testList));
    }
}
