package com.mon.algosgigster;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TreeConstructor {
    /*
    * Tree Constructor
    Have the function TreeConstructor(strArr) take the array of strings stored in strArr, which will contain pairs of
    integers in the following format: (i1,i2), where i1 represents a child node in a tree and the second integer i2
    signifies that it is the parent of i1. For example: if strArr is ["(1,2)", "(2,4)", "(7,2)"], then this forms the
    following tree:
    *           4
    *          /
    *         2
    *        / \
    *       1   7
    which you can see forms a proper binary tree. Your program should, in this case, return the string true because
    a valid binary tree can be formed. If a proper binary tree cannot be formed with the integer pairs, then return the
    string false. All of the integers within the tree will be unique, which means there can only be one node in the tree
    with the given integer value.
    Examples
    Input: new String[] {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"}
    Output: true
    Input: new String[] {"(1,2)", "(3,2)", "(2,12)", "(5,2)"}
    Output: false
    * */

    public static boolean constructTree(String[] strArr){
        Map<String, Boolean> parentsOf = new HashMap<>();
        Map<String, Integer> childrenOf = new HashMap<>();

        for(String str: strArr){
            String[] nodes = str.split(",");
            String firstNode = nodes[0];
            String secondNode = nodes[1];

            if(parentsOf.containsKey(firstNode)) return false;
            else parentsOf.put(firstNode, true);

            if(childrenOf.containsKey(secondNode)){
                if(childrenOf.get(secondNode) == 1){
                    childrenOf.put(secondNode, 2);
                }else return false;
//                childrenOf.put(secondNode, childrenOf.get(secondNode) + 1);
//                if(childrenOf.get(secondNode) > 2) return false;
            }else childrenOf.put(secondNode, 1);

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(constructTree(new String[]{"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"}));
        System.out.println(constructTree(new String[]{"(1,2)", "(3,2)", "(2,12)", "(5,2)"}));

    }
}
