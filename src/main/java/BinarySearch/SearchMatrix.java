package BinarySearch;

public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int target = 11;
        boolean res = isInMatrix(matrix, target);
        System.out.println(res);
    }

    private static boolean isInMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midX = mid / n;
            int midY = mid % n;
            if (matrix[midX][midY] == target) {
                return true;
            } else if (matrix[midX][midY] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
