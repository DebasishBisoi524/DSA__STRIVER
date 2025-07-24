// package FAQ_Medium;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Problems pr = new Problems();
        int[] arr1 = { 1, 2, 5, 3, 1, 2 };
        int[] arr2 = { 2, 4, 5, -1, -3, -4 };
        int[] arr3 = { 4, 5, 3, 2, 1 };
        int[] arr4 = { 2, -2, 0, 3, -3, 5 };
        int[] arr5 = { 1, -2, 3, 5, 7, 9 };
        int[] arr6 = { 0, 1, 0, 1, 2, 2, 1, 0, 1, 2, 0 };
        int[] arr7 = { 2, 3, 5, -8, 7, -4 };
        int[] arr8 = { 1, 1, 5 };
        int[] arr9 = { 1, 2, 4, 8, 16, 32, 64 };
        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        pr.leaders(arr1);
        pr.rearrangeArray(arr2);
        pr.spiralMatrix(mat);
        pr.pascalTriangleI(6, 2);
        pr.pascalTriangleII(5);
        pr.pascalTriangleIII(4);
        pr.rotateMatrix(mat);
        pr.twoSum(arr3, 9);
        pr.threeSum(arr4);
        pr.fourSum(arr5, 7);
        pr.sortZeroOneTwo(arr6);
        pr.maxSubArray(arr7);
        pr.nextPermutation(arr8);
        pr.findDoublePairs(arr9);
    }
}

class Problems {
    public int[] leaders(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        if (n == 0) {
            System.out.println("The Array is Empty.");
            return arr;
        }
        int max = arr[n - 1];
        list.add(max);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                list.add(arr[i]);
                max = arr[i];
            }
        }
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
        int[] ans = new int[list.size()];
        int index = 0;
        for (int num : list) {
            ans[index++] = num;
        }
        System.out.println("The leaders of the list are: " + Arrays.toString(ans));
        return ans;
    }

    public int[] rearrangeArray(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int even = 0, odd = 1;
        for (int n : nums) {
            if (n >= 0) {
                result[even] = n;
                even += 2;
            } else {
                result[odd] = n;
                odd += 2;
            }
        }
        System.out.println("After rearranging the array:" + Arrays.toString(result));
        return result;
    }

    public List<Integer> spiralMatrix(int[][] arr) {
        List<Integer> spiral = new ArrayList<>();
        // length of row
        int n = arr.length;
        // Length of column
        int m = arr[0].length;

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                spiral.add(arr[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                spiral.add(arr[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    spiral.add(arr[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    spiral.add(arr[i][left]);
                }
                left++;
            }
        }
        System.out.println("The spiral matrix is: " + spiral);
        return spiral;
    }

    public int pascalTriangleI(int r, int c) {
        int result = nCr(r - 1, c - 1);
        System.out.println("The element in the " + ordinal(r) + " row and " + ordinal(c) +
                " column in Pascal's triangle is: " + result);
        return result;
    }

    private int nCr(int n, int r) {
        if (r > n - r)
            r = n - r;
        if (r == 0)
            return 1;
        if (r == 1)
            return n;
        int result = 1;
        for (int i = 0; i < r; i++) {
            result = result * (n - i);
            result = result / (i + 1);
        }
        return result;
    }

    private String ordinal(int num) {
        if (num % 100 >= 11 && num % 100 <= 13)
            return num + "th";
        return switch (num % 10) {
            case 1 -> num + "st";
            case 2 -> num + "nd";
            case 3 -> num + "rd";
            default -> num + "th";
        };
    }

    public int[] pascalTriangleII(int r) {
        int[] result = new int[r];
        result[0] = 1;
        for (int i = 1; i < r; i++) {
            result[i] = ((r - i) * result[i - 1]) / i;
        }
        System.out.println("After rearranging the array: " + Arrays.toString(result));
        return result;
    }

    public List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> pascalTriangleList = new ArrayList<>();
        for (int row = 1; row <= n; row++) {
            pascalTriangleList.add(generateRow(row));
        }
        System.out.println("The Pascal triangle: " + pascalTriangleList);
        return pascalTriangleList;
    }

    private List<Integer> generateRow(int row) {
        long result = 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for (int col = 1; col < row; col++) {
            result *= (row - col);
            result /= col;
            list.add((int) result);
        }
        return list;
    }

    public void rotateMatrix(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
            }
        }
        System.out.println("Rotated Matrix:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        int[] ans = new int[2];
        int[][] elemIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            elemIndex[i][0] = arr[i]; // value of i
            elemIndex[i][1] = i; // original Index
        }
        Arrays.sort(elemIndex, (a, b) -> Integer.compare(a[0], b[0]));
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int sum = elemIndex[left][0] + elemIndex[right][0];
            if (sum == target) {
                ans[0] = elemIndex[left][1];
                ans[1] = elemIndex[right][1];
                System.out.print("The Indices are " + ans[0] + " and " + ans[1]);
                System.out.println(" and the values are: " + elemIndex[left][0] + " and " + elemIndex[right][0]);
                return ans;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println("No Pairs Found.");
        return new int[] { -1, -1 };
    }

    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i < 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    list.add(temp);
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }
                    while (j < k && arr[k] == arr[k + 1]) {
                        k--;
                    }
                }
            }
        }
        System.out.println("Triplet array elements with zero sum: " + list);
        return list;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        list.add(temp);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    } else if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    }
                }
            }
        }
        System.out.println("Quadruplets that sum to target: " + list);
        return list;
    }

    public void sortZeroOneTwo(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
        System.out.println(
                "Using Dutch National Flag Algoritm, The Arrays of 0s, 1s and 2s become: " + Arrays.toString(nums));
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int maxSubArray(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;
        for (int i = 0; i < n; i++) {
            if (sum == 0) {
                start = i;
            }
            sum += arr[i];
            if (sum > max) {
                max = sum;
                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.print("Max subarray: ");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("The Max Sum of the Array is: " + max);
        return max;
    }

    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(arr, 0, n - 1);
        }
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > arr[index]) {
                swap(arr, index, i);
                break;
            }
        }
        reverse(arr, index + 1, n - 1);
        System.out.print("Next permutation: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        return;

    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public List<List<Integer>> findDoublePairs(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> temp = new ArrayList<>();
        for (int num : arr) {
            set.add(num);
        }

        for (int num : arr) {
            if (set.contains(num * 2)) {
                List<Integer> temp1 = new ArrayList<>();
                temp1.add(num);
                temp1.add(num * 2);
                temp.add(temp1);
            }
        }
        System.out.println("The Pairs are: " + temp);
        return temp;
    }
}