package com.daily.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TowerOfHanoi {

    // there are three rods and n disks


    public List<List<Integer>> getMoves(int n) {

        // inner list should only have length 2 ---> FROM, TO.  outer list is the full sequence of moves
        List<List<Integer>> moves = new ArrayList<List<Integer>>();

        Stack<Integer> rod1 = new Stack<>();
        Stack<Integer> rod2 = new Stack<>();
        Stack<Integer> rod3 = new Stack<>();

        boolean empty1 = false;
        boolean empty2 = true;
        boolean empty3 = true;

        // initialize rod1
        for(int i = n; i > 0; i--) {
            rod1.push(i);
        }

        return moves;
    }

}
