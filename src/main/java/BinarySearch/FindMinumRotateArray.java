package BinarySearch;

public class FindMinumRotateArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 0, 1, 2, 3};
        int min = findMinInRotateArray(nums);
        System.out.println(min);
    }

    private static int findMinInRotateArray(int[] nums) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[mid + 1];
    }
}
