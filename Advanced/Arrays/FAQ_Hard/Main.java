
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] arr1 = {7, 0, 0, 7, 7, 7, 7};
        int[] arr2 = {1, 2, 1, 1, 3, 3, 3, 3, 3, 2, 2};
        int[] arr3 = {4, 3, 2, 1, 1, 6};
        int[] arr4 = {40, 25, 19, 12, 4, 6, 2};
        Solution s1 = new Solution();
        s1.majorityElement(arr1);
        s1.majorityElementTwo(arr2);
        s1.findMissingRepeatingNumbers(arr3);
        s1.numberOfInversions(arr3);
        s1.reversePairs(arr4);
        s1.maxProduct(arr1);
    }
}

class Solution {

    public int majorityElement(int[] arr) {
        int n = arr.length;
        int count = 0;
        int el = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                el = arr[i];
            } else if (el == arr[i]) {
                count++;
            } else {
                count--;
            }
        }
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == el) {
                counter++;
            }
        }
        if (counter > n / 2) {
            System.out.println("1. Majority element found: " + el);
            return el;
        }
        System.out.println("No Majority elments are found");
        return -1;
    }

    public List<Integer> majorityElementTwo(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int cnt1 = 0;
        int cnt2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != nums[i]) {
                cnt1 = 1;
                el1 = nums[i];
            } else if (cnt2 == 0 && el1 != nums[i]) {
                cnt2 = 1;
                el2 = nums[i];
            } else if (nums[i] == el1) {
                cnt1++;
            } else if (nums[i] == el2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        int count1 = 0, count2 = 0;
        for (int i = 0; i < n; i++) {
            if (el1 == nums[i]) {
                count1++;
            }
            if (el2 == nums[i]) {
                count2++;
            }
        }
        int min = (n / 3) + 1;
        if (count1 >= min) {
            list.add(el1);
        }
        if (count2 >= min && el1 != el2) {
            list.add(el2);
        }
        System.out.println("2. Two Majority element found: " + list);
        return list;
    }

    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;
        int SN = (n * (n + 1)) / 2; // sum of n natural numbers //
        int S2N = (n * (n + 1) * (2 * n + 1)) / 6; // sum of squares of n natural numbers //
        int S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += nums[i];
            S2 += nums[i] * nums[i];
        }
        int val1 = S - SN;
        int val2 = S2 - S2N;
        val2 = val2 / val1;

        int x = (val1 + val2) / 2;
        int y = x - val1;
        System.out.println("3. The Repeating and Missing Number is: " + x + " and " + y);
        return new int[]{x, y};
    }

    public long numberOfInversions(int[] nums) {
        int n = nums.length;
        long count = mergeSort(nums, 0, n - 1);
        System.out.println("4. Total Number of Inversions are: " + count);
        return count;
    }

    public long mergeSort(int[] arr, int low, int high) {
        long count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            count += merge(arr, low, mid, high);
        }
        return count;
    }

    public long merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        long count = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                count += (mid - left + 1);
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
        return count;
    }

    public int reversePairs(int[] arr) {
        int n = arr.length;
        int count = mergeSortI(arr, 0, n - 1);
        System.out.println("5. Total Number of Reverse Pairs are: " + count);
        return count;
    }

    public int mergeSortI(int[] arr, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            count += mergeSortI(arr, low, mid);
            count += mergeSortI(arr, mid + 1, high);
            count += countReversePairs(arr, low, mid, high);
            merge(arr, low, mid, high);
        }
        return count;
    }

    private int countReversePairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;
        for (int left = low; left <= mid; left++) {
            while (right <= high && arr[left] > 2 * arr[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    @SuppressWarnings("ManualArrayToCollectionCopy")
    public void mergeI(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[high - low + 1];
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i];
                i++;
            } else {
                temp[k++] = arr[j];
                j++;
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i];
            i++;
        }
        while (j <= high) {
            temp[k++] = arr[j];
            j++;
        }
        int length = temp.length;
        for (int p = 0; p < length; p++) {
            arr[low + p] = temp[p];
        }
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        int suffix = 1;
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            prefix *= nums[i];
            suffix *= nums[n - i - 1];
            maxProd = Math.max(maxProd, Math.max(prefix, suffix));
        }
        System.err.println("6. Maximum Product of Array is: " + maxProd);
        return maxProd;
    }

    public void mergeTwoSortedArrays(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        int gap = (length / 2) + (length % 2);
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < length) {
                if (left < m && right < m) {
                    swapIfGreater(nums1, nums1, left, right);
                } else if (left < m && right >= m) {
                    swapIfGreater(nums1, nums2, left, right - m);
                } else {
                    swapIfGreater(nums2, nums2, left - m, right - m);
                }
                left++;
                right++;
            }
            if (gap == 1) {
                break;
            } else {
                gap = (gap / 2) + (gap % 2);
            }
        }
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        System.out.println("7. Merged Array is: " + Arrays.toString(nums1));
    }

    private void swapIfGreater(int[] nums1, int[] nums2, int index1, int index2) {
        if (nums1[index1] > nums2[index2]) {
            int temp = nums1[index1];
            nums1[index1] = nums2[index2];
            nums2[index2] = temp;
        }
    }
}
