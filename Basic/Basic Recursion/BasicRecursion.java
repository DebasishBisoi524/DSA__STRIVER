import java.util.ArrayList;

public class BasicRecursion {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        Recursion r1 = new Recursion();
        r1.sumOfNaturalNumbers(10);
        r1.isSorted(nums);
    }
}

class Recursion {
    public int sumOfNaturalNumbers(int N) {
        int result = sumHelper(N);
        System.out.println("The sum Of the First " + N + " Natural Numbers is: " + result);
        return result;
    }

    private int sumHelper(int N) {
        if (N == 0) {
            return 0;
        }
        return N + sumHelper(N - 1);
    }

    public boolean isSorted(ArrayList<Integer> nums) {
        if (nums.size() <= 1) {
            return true;
        }
        return sort(nums, 0, 1);
    }

    private boolean sort(ArrayList<Integer> nums, int left, int right) {
        if (right >= nums.size()) {
            return true;
        }
        if (nums.get(left) > nums.get(right)) {
            return false;
        }
        return sort(nums, left + 1, right + 1);
    }

}