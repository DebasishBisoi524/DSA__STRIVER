package main;

import array.Array;

public class Main {

    public static void main(String[] args) {
        Array a1 = new Array();
        int arr[] = { 1, 2, 3, 4, 5 };
        a1.sumOfArrayElements(arr, 5);
        a1.reverseArray(arr);
        a1.countOddNumber(arr);
        a1.isSorted(arr);
        a1.reverse(arr);
    }
}