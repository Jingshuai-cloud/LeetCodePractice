package BinarySearch;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int target = 0;
        int[] nums = {4,5,6,7,0,1,2};
        int res = binarySearchArray(nums, target);
        System.out.println(res);

    }

    private static int binarySearchArray(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid] && (target > nums[mid] || target < nums[left])) {
                left = mid + 1;
            } else if (target > nums[mid] && target < nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left == right && nums[left] == target ? left : -1;
    }
}
