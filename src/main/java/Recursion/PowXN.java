package Recursion;

public class PowXN {
    public static void main(String[] args) {
        double x = 2.00;
        int n = 10;
        double result = powRecursion(x, n);
        System.out.println(result);
    }

    private static double powRecursion(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        return n % 2 == 0 ? powRecursion(x * x, n / 2) : x * powRecursion(x * x, (n - 1) / 2);
    }
}
