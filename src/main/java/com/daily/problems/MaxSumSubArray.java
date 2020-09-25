package com.daily.problems;

/*
Given an array of numbers, find the maximum sum of any contiguous subarray of the array.

For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.

Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

Do this in O(N) time.
 */

/*
I looked up the solution for this one.  I was very close, but not quite there, and I found myself adding a bunch of conditionals to handle each case.
so it was getting messy and confusing.

This algorithm is known as Kadane'e algorithm:

def max_subarray_sum(arr):
     max_ending_here = max_so_far = 0
     for x in arr:
         max_ending_here = max(x, max_ending_here + x)
         max_so_far = max(max_so_far, max_ending_here)
     return max_so_far
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
        String input;
        while(continueFlag) {
            System.out.println("Enter a list of comma-separated integers: ");
            input = scanner.nextLine();
            String tokens[] = input.split(",");
            int result = findMaxSum(tokens);
            System.out.println("The maximum value is: " + result);
            System.out.println("Continue? Press Q to quit");
            String con = scanner.nextLine();
            if(con.equalsIgnoreCase("Q")) {
                continueFlag = false;
            }
        }
    }


    public static int findMaxSum(String[] tokens) {

        // convert to integers
        Integer[] integers = prepareInputData(tokens);

        int max = integers[0];
        int testMax = 0;
        int currSum = 0;
        int currLocation = 0;
        int end = currLocation;

        while(currLocation < integers.length) {

            if(currLocation == end) {
                currSum = integers[currLocation];
                if(currSum > max) {
                    max = currSum;
                }
                end++;
            } else {
                testMax = max + integers[end];
                currSum += integers[end];
                if(currSum > max) {
                    max = currSum;
                    if(end == integers.length - 1) {
                        return max;
                    }
                    end++;
                } else {
                    currLocation++;
                    end = currLocation;
                }
            }
        }

        return max;
    }

    // read input as string, so we need to transform to integers
    private static Integer[] prepareInputData(String[] tokens) {

        Integer[] integers = new Integer[tokens.length];
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < tokens.length; i++) {
            integers[i] = Integer.parseInt(tokens[i].trim());
        }
        return integers;
    }
}
