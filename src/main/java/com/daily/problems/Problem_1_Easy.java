package com.daily.problems;

/*
This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
 */

import java.util.*;

public class Problem_1_Easy {

    private boolean continueFlag = false;

    private static SortedMap<Integer, Integer> map = new TreeMap<>();

    public void check() {
        continueFlag = true;
        Scanner scanner = new Scanner(System.in);
        String input;
        int testSum;

        System.out.println("Welcome!  Description: Given a list of numbers and a number k, return whether any two numbers from the list add up to k.");
        while (continueFlag) {
            System.out.println("Enter a list of comma-separated integers: ");
            input = scanner.nextLine();
            String[] tokens = input.split(",");
            System.out.println("Enter one integer: ");
            testSum = Integer.parseInt(scanner.nextLine());
            Integer[] integers = convertToInteger(tokens);
            createTreeMap(integers);
            boolean isASum = check(testSum);
            System.out.println("Two integers in your list add to " + testSum + ": " + isASum);
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

    private static void createTreeMap(Integer[] list) {
        map.clear();
        for(Integer i : list) {
            if(map.containsKey(i)) {
                Integer count = map.get(i);
                count++;
                map.put(i, count);
            } else {
                map.put(i, 1);
            }
        }
    }

    public static boolean check(int testSum) {
        // iterate over treemap:
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer i = entry.getKey();
            Integer missing = testSum - i;
            if(missing.equals(i)) {
                // see if there are two copies of this in the map
                if(map.get(i) > 1) {
                    return true;
                }
                return false;
            }
            if (map.containsKey(missing)) {
                return true;
            }
        }
        return false;
    }
}
