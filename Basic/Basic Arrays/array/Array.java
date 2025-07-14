package array;

import java.util.Arrays;

public class Array {
    public int sumOfArrayElements(int arr[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        System.out.println("The sum of the elements of the array is: " + sum);
        return sum;
    }

    public int[] reverseArray(int arr[]) {
        int n = arr.length;
        int rev[] = new int[n];
        for (int i = 0; i < n; i++) {
            rev[i] = arr[n - i - 1];
        }
        System.out.println("Reversed Array: " + Arrays.toString(rev));
        return rev;
    }

    public int countOddNumber(int arr[]) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                count++;
            }
        }
        System.out.println("The number of odd numbers in the array is: " + count);
        return count;
    }

    public void reverse(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
        System.out.println("The Reverse array is without any extra array space : " + Arrays.toString(arr));
    }

    public boolean isSorted(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println("The Array " + Arrays.toString(arr) + " is not Sorted.");
                return false;
            }
        }
        System.out.println("The Array " + Arrays.toString(arr) + " is Sorted.");
        return true;
    }
}
