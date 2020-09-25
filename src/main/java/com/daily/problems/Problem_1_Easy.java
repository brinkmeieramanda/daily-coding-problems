package com.daily.problems;

/*
This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem_1_Easy {

    private static boolean continueFlag = false;

    public static void testSum() {
        continueFlag = true;
        Scanner scanner = new Scanner(System.in);
        String input;
        int testSum;

        System.out.println("Welcome!  Description: Given a list of numbers and a number k, return whether any two numbers from the list add up to k.");
        while (continueFlag) {
            System.out.println("Enter a list of comma-separated integers: ");
            input = scanner.nextLine();
            String[] tokens = input.split(",");
            System.out.println("Enter one inter: ");
            testSum = Integer.parseInt(scanner.nextLine());
            Integer[] integers = convertToInteger(tokens);
            boolean isASum = testSum(integers, testSum);
            System.out.println("Two integers in your list add to " + testSum + ":" + isASum);
            System.out.println("Continue? Press Q to quit");
            String con = scanner.nextLine();
            if (con.equalsIgnoreCase("Q")) {
                continueFlag = false;
            }
        }

        return;
    }

    private static Integer[] convertToInteger(String[] tokens) {
        Integer[] result = new Integer[tokens.length];
        for(int i = 0; i < tokens.length; i++) {
            result[i] = Integer.parseInt(tokens[i]);
        }
        return result;
    }

    public static boolean testSum(Integer[] list, int testSum) {

        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(list));
        for(Integer i : list) {
            if(set.contains(testSum - i)) {
                return true;
            }
        }
        return false;
    }
}
