import java.util.*;

public class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Algorithm algo = new Algorithm();

        System.out.print("Enter length of array: ");
        int length = sc.nextInt();

        int[] inputArr = new int[length];
        System.out.println("Enter elements:");
        for (int i = 0; i < length; i++) {
            inputArr[i] = sc.nextInt();
        }

        System.out.println("\nChoose Sorting Algorithm:");
        System.out.println("1. Insertion Sort");
        System.out.println("2. Merge Sort");
        System.out.println("3. Quick Sort");
        System.out.println("4. Selection Sort");
        System.out.println("5. Bubble Sort");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        int[] arr = Arrays.copyOf(inputArr, inputArr.length);

        switch (choice) {
            case 1:
                algo.insertionSort(arr);
                break;
            case 2:
                algo.mergeHelper(arr);
                break;
            case 3:
                algo.quickSortHelper(arr);
                break;
            case 4:
                algo.selectionSort(arr);
                break;
            case 5:
                algo.bubbleSort(arr);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        sc.close();
    }
}

class Algorithm {
    public int[] insertionSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr, j - 1, j);
                j--;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        System.out.println("The Insertion Sorted List is: " + list);
        return arr;
    }

    public void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        ArrayList<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int j = 0; j < temp.size(); j++) {
            arr[low + j] = temp.get(j);
        }
    }

    public int[] mergeHelper(int[] arr) {
        int n = arr.length;
        mergeSort(arr, 0, n - 1);
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        System.out.println("The Merge Sorted List is: " + list);
        return arr;
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
        int randomIndex = low + (int) (Math.random() * (high - low + 1));
        swap(arr, randomIndex, high);

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public int[] quickSortHelper(int[] arr) {
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        System.out.println("The QuickSort Sorted List is: " + list);
        return arr;
    }

    public int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(nums, i, minIndex);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        System.out.println("The Selection Sort Sorted List is: " + list);
        return nums;
    }

    public int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        System.out.println("The Bubble Sort Sorted List is: " + list);
        return nums;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}