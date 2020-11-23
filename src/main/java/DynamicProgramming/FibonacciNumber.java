package DynamicProgramming;

public class FibonacciNumber {


    public static void main(String[] args) {
        int n = 5;
        int res = fib(4);
        int res2 = bottomUp(4);
        int res3 = topDown(4);
        int res4 = iterative(4);
        System.out.println(res4);
    }

    private static int fib(int n) {
        if (n <= 1) return n;

        return fib(n - 1) + fib(n - 2);
    }

    //Dynamic Programming Time/Space O(n)
    public static  int bottomUp(int n) {
        if (n <=1 ) return n;

        int cache[] = new int[n + 1];
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    //Dynamic Programming  Time/Space O(n)
    private static int[] fib_cache = new int[31];
    public static int topDown(int n) {
        if (n <= 1) return n;

        if (fib_cache[n] != 0) {
            return fib_cache[n];
        }else {
            return fib_cache[n] = topDown(n - 1) + topDown(n - 2);
        }

    }

    //Iterative  Time O(n)  Space O(1)
    public static int iterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        while (n-- > 1) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
