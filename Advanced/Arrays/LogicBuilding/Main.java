// package LogicBuilding;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = { 12, 0, 4, 23, 0, 21 };
        int[] arr2 = { 1, 1, 1, 2, 3, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7 };
        int[] arr3 = { 1, 2, 3, 4, 5 };
        int[] arr4 = { 3, 4, 5, 6, 7 };
        Problems pr = new Problems();
        pr.moveZeroesToEnd(arr1);
        pr.removeDuplicates(arr2);
        pr.findMisingNumber(arr3);
        pr.unionArray(arr3, arr4);
        pr.intersectionOfArray(arr3, arr4);
    }
}

class Problems {
    public void moveZeroesToEnd(int[] arr) {
        int n = arr.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                if (i != j) {
                    swap(arr, i, j);
                }
                j++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        System.out.println("After Moving zeroes to the end, the array is: " + list);
    }

    public int removeDuplicates(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            System.out.println("Array is empty");
            return 0;
        }
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int k = 0; k <= i; k++) {
            list.add(arr[k]);
        }
        System.out.print("After removing duplicates in the array is: " + list);
        System.out.println(" And the no of unqiues elements are: " + (i + 1));
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int findMisingNumber(int[] arr) {
        int xor1 = 0;
        int xor2 = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            xor1 ^= (i + 1);
            xor2 ^= arr[i];
        }
        int missing = xor1 ^ xor2;
        System.out.println("The Missing element in the array is: " + missing);
        return missing;
    }

    public int[] unionArray(int[] arr1, int[] arr2) {
        ArrayList<Integer> unionList = new ArrayList<>();
        int n = arr1.length;
        int m = arr2.length;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != arr1[i]) {
                    unionList.add(arr1[i]);
                }
                i++;
            } else {
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != arr2[j]) {
                    unionList.add(arr2[j]);
                }
                j++;
            }
        }

        while (i < n) {
            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != arr1[i]) {
                unionList.add(arr1[i]);
            }
            i++;
        }
        while (j < m) {
            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != arr2[j]) {
                unionList.add(arr2[j]);
            }
            j++;
        }
        int[] union = new int[unionList.size()];
        int index = 0;
        for (int num : unionList) {
            union[index++] = num;
        }
        System.out.println("The Array after the union: " + Arrays.toString(union));
        return union;
    }

    public int[] intersectionOfArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            } else {
                temp.add(arr1[i]);
                i++;
                j++;
            }
        }
        int[] ans = new int[temp.size()];
        int index = 0;
        for (int num : temp) {
            ans[index++] = num;
        }
        System.out.println("The Intersection between two arrays is: " + Arrays.toString(ans));
        return ans;
    }
}