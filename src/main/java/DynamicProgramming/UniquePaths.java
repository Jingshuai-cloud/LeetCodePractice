package DynamicProgramming;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 6, n = 3;
        int res = dynamicProgramming(m,n);
        System.out.println(res);

        int res2 = dynamicProgrammingAdvanced(m,n);
        System.out.println(res2);
    }

    //Time O(mn) SpaceO(m)
    private static int dynamicProgrammingAdvanced(int m, int n) {
        int [] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[m - 1];
    }

    //Time O(mn) SpaceO(mn)
    private static int dynamicProgramming(int m, int n) {
        int [][] dp = new int [m][n];
        //fill the array's border with 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


}
