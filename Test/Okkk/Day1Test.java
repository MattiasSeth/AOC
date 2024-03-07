package Ok;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Day6Test {

    @Test
    public void testCalculate() {
        Day6 d6 = new Day6();

        assertEquals(11, d6.calculate(Arrays.asList("abc"," ","a","b","c"," ","ab","ac"," ", "a","a","a","a"," ","b")));
    }
}
