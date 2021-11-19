package org.example.lab1;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class Lab1Test {
    private static final String PROJECT_PATH = Paths.get("").toAbsolutePath().toString();
    private static final String SAVE_FILE = PROJECT_PATH + File.separator + "file.txt";

    @Test
    void testLab1() {
        Lab1 l = new Lab1(new int[][]{{1, 0, 0}, {0, 1, 1}}, new int[]{2, 1});
        int[] check = new int[]{1, 2, 2};
        for (int i = 0; i < 3; i++) {
            assertEquals(check[i], l.getResult()[i]);
        }

        assertEquals(2, l.getCommonDenominator());
    }

    @Test
    void testToString() {
        assertEquals("32x^2+2x^1+1x^0", Utils.toString(new int[]{1, 2, 32}));
        assertEquals("2x^2+1x^1+32x^0", Utils.toString(new int[]{32, 1, 2}));
    }

    @Test
    void commonDenominator() {
        assertEquals(6, Utils.commonDenominator(new int[]{2, 3}));
        assertEquals(10, Utils.commonDenominator(new int[]{5, 2}));
        assertEquals(3, Utils.commonDenominator(new int[]{1, 3}));
    }

    @Test
    void readFromFile() {
        assertNotNull(Utils.readFromFile(SAVE_FILE));
    }

    @Test
    void example(){}
}