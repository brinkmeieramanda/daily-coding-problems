package com.daily.problems;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Problem_1_EasyTest {

    @Test
    public void testGivenExample() {
        Integer[] list = {10, 15, 3, 7};
        int testSum = 17;
        boolean result = Problem_1_Easy.testSum(list, testSum);
        assertEquals(result, true);
    }

    @Test
    public void testShouldBeFalse() {
        Integer[] list = {10, 15, 3, 7};
        int testSum = 100;
        boolean result = Problem_1_Easy.testSum(list, testSum);
        assertEquals(result, false);
    }

    // my implementation allows numbers to be used twice --> 10 + 10 = 20
    @Test
    public void testMulti() {
        Integer[] list = {10, 15, 3, 7};
        int testSum = 20;
        boolean result = Problem_1_Easy.testSum(list, testSum);
        assertEquals(result, true);
    }

    @Test
    public void testAllSame() {
        Integer[] list = {3, 3, 3, 3};
        int testSum = 3;
        boolean result = Problem_1_Easy.testSum(list, testSum);
        assertEquals(result, false);
    }

}