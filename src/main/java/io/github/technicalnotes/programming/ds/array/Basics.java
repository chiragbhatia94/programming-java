package io.github.technicalnotes.programming.ds.array;

import java.util.Arrays;

/**
 * Arrays are homogenous data structures, i.e. they store the value of same type, it has the following properties:
 * - it is of fixed length, when an array is created they are created in stack with static sizes
 */
public class Basics {
    public static void main(String[] args) {
        // declaration
        int[] a1 = new int[3];
        for (int t : a1) {
            System.out.println(t);
        }

        // declaration with initialization
        int[] a2 = new int[]{1, 2};
        System.out.println(Arrays.toString(a2));

        // declaring & initializing a multidimensional array
        int[][] a3 = new int[][]{{2, 3}, {1, 3, 4}};
        for (int[] t : a3) {
            System.out.println(Arrays.toString(t));
        }
    }
}
