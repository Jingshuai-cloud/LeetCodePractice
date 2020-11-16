package BinarySearch;

public class BinarySearchTemplate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;
        int index = binarySearch(nums, target);
        System.out.println(index);
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid  = (left + right) / 2 + left;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
