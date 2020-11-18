package BinarySearch;

public class Sqrtx {
    public static void main(String[] args) {
     int input = 8;
     int res = binarySearchSqrtx(input);
     int result = newton(input);
     System.out.println(res);
     System.out.println(result);

    }

    private static int newton(int input) {
        int res = input;
        while (res * res > input)
            res = (res + input / res) / 2;
        return res;
    }

    //Time O(logn) Space O(1)
    private static int binarySearchSqrtx(int input) {
        int left = 0, right = input, ans = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid * mid <= input) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

}
