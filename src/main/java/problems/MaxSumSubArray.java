package problems;

/*
Given an array of numbers, find the maximum sum of any contiguous subarray of the array.

For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.

Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

Do this in O(N) time.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    For sample input, see resources/maxSumSubArray.txt
 */

public class MaxSumSubArray {

    private static boolean continueFlag = false;

    public static void findMaxSumInteractive() {
        continueFlag = true;
        Scanner scanner = new Scanner(System.in);

        while(continueFlag) {
            System.out.println("Enter a list of comma-separated integers: ");
            String tokens[] = scanner.nextLine().split(",");
            int result = findMaxSum(tokens);
            System.out.println("The maximum value is: " + result);
            System.out.println("Continue? Press Q to quit");
            String con = scanner.next();
            if(con.equalsIgnoreCase("Q")) {
                continueFlag = false;
            }
        }
    }


    public static int findMaxSum(String[] tokens) {

        // convert to integers
        Integer[] integers = prepareInputData(tokens);

        int maxSum = integers[0] > 0 ? integers[0] : 0;
        int currLocation = 0;
        int subArrayEnd = 1;

        while(currLocation <= integers.length - 1) {
            int test = maxSum + integers[subArrayEnd];
            if( test > maxSum) {
                maxSum = test;
                subArrayEnd++;
            } else {
                currLocation++;
            }
        }

        return maxSum;
    }

    private static Integer[] prepareInputData(String[] tokens) {

        Integer[] integers = new Integer[tokens.length];
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < tokens.length; i++) {
            integers[i] = Integer.parseInt(tokens[i].trim());
        }
        return integers;
    }
}
