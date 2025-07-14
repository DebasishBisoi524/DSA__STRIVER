package Fundamentals;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Problems problem = new Problems();
        int[] arr1 = { 12, 48, 100, 89, 28, 40 };
        int[] arr2 = { 1, 1, 0, 0, 1, 1, 1, 0 };
        problem.linearSearch(arr1, 40);
        problem.largestElement(arr1);
        problem.secondLargestElement(arr1);
        problem.findMaxConsecutiveOnes(arr2);
        problem.leftRotate(arr1, 5);
    }
}

class Problems {
    public int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("The Index of the element " + target + " is: " + i);
                return i;
            }
        }
        System.out.println("No such element is found");
        return -1;
    }

    public int largestElement(int[] arr) {
        int largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        System.out.println("The Largest Element is: " + largest);
        return largest;
    }

    public int secondLargestElement(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return -1;
        }

        boolean hasNegative = false;
        for (int num : nums) {
            if (num < 0) {
                hasNegative = true;
                break;
            }
        }

        int largest = hasNegative ? Integer.MIN_VALUE : -1;
        int secondLargest = hasNegative ? Integer.MIN_VALUE : -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            } else if (nums[i] > secondLargest && nums[i] != largest) {
                secondLargest = nums[i];
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            return -1;
        }

        System.out.println("Second Largest element is: " + secondLargest);
        return secondLargest;
    }

    public int findMaxConsecutiveOnes(int[] arr) {
        int n = arr.length;
        int count = 0;
        int maximum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                count++;
                if (maximum < count) {
                    maximum = count;
                }
            } else {
                count = 0;
            }
        }
        System.out.println("The Maximum Consecutives Ones are: " + maximum);
        return maximum;
    }

    public void leftRotate(int[] arr, int time) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int n = arr.length;
        time = time % n; 

        if (time <= 0) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : arr) {
                list.add(num);
            }
            System.out.println("The Left Rotated Array is: " + list);
            return;
        }

        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;

        leftRotate(arr, time - 1);
    }

}