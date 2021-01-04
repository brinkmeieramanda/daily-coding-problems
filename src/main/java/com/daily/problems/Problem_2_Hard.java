package com.daily.problems;

/*

    /*
    This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
     */


import java.util.Arrays;
import java.util.Scanner;

public class Problem_2_Hard {

    private static boolean continueFlag = false;

    public static void testProduct() {

        continueFlag = true;
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome!  Description: Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.");
        while(continueFlag == true) {
            System.out.println("Enter a list of comma-separated integers: ");
            input = scanner.nextLine();
            String[] tokens = input.split(",");
            Integer[] integers = convertToInteger(tokens);
            Integer[] result = getArrayOfProducts(integers);
            Arrays.stream(result).forEach(integer -> System.out.println(integer + ", "));
            System.out.println("Continue? Press Q to quit");
            String con = scanner.nextLine();
            if (con.equalsIgnoreCase("Q")) {
                continueFlag = false;
            }
        }
    }

    private static Integer[] getArrayOfProducts(Integer[] input) {
        Integer[] result = new Integer[input.length];
        int productOfAll = getProduct(input);
        for(int i = 0; i < input.length; i++) {
            result[i] = input[i] == 0 ? 0 : productOfAll / input[i];
        }
        return result;
    }

    private static Integer[] convertToInteger(String[] tokens) {
        Integer[] result = new Integer[tokens.length];
        for(int i = 0; i < tokens.length; i++) {
            result[i] = Integer.parseInt(tokens[i]);
        }
        return result;
    }

    private static int getProduct(Integer[] nums) {
        Integer product = 1;
        for(int i = 0; i < nums.length; i++) {
            product = product * nums[i];
        }
        return product;
    }

}
