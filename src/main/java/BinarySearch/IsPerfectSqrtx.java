package BinarySearch;

public class IsPerfectSqrtx {
    public static void main(String[] args) {
        int input = 16;
        boolean res = isSqrtxBinarySearch(input);
        System.out.println(res);
        boolean res2 = newton(input);
    }

    private static boolean newton(int input) {
        int r = input;
        while (r * r > input)
            r = (r + input / r) / 2;
        return r * r == input;
    }

    private static boolean isSqrtxBinarySearch(int input) {
        int left = 0, right = input;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == input) return true;
            if (mid * mid > input) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }

}
