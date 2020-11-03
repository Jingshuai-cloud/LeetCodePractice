package Recursion;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbingStars(n));
    }

    //Time O(n) Spacr O(1)
    private static int climbingStars(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int first = 1, second = 2, third = 3;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}
