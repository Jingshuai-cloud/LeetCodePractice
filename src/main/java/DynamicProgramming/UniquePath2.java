package DynamicProgramming;

public class UniquePath2 {
    public static void main(String[] args) {
        int[][] obstacle_array = {{0,0,0,0},{1,1,0,1},{0,0,0,0}};
        int res = dynamicProgramming(obstacle_array);
        System.out.println(res);

        int res2 = dynamicProgrammingAdvanced(obstacle_array);
        System.out.println(res2);
    }

    //Time O(mn) SpaceO(m)
    private static int dynamicProgrammingAdvanced(int[][] obstacle_array) {
        int width = obstacle_array[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int i = 0; i < obstacle_array.length; i++) {
            for (int j = 0; j < width; j++) {
                if (obstacle_array[i][j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j]+= dp[j - 1];
            }
        }
        return dp[width - 1];
    }

    //Time O(mn) Space O(mn)
    private static int dynamicProgramming(int[][] obstacle_array) {
        int m = obstacle_array.length; int n = obstacle_array[0].length;
        int dp[][] = new int[m][n];

        //fill the first line
        for (int i = 0; i < m; i++) {
            if (obstacle_array[0][i] == 1) {
                dp[0][i] = 0;
                break;
            }else
                dp[0][i] = 1;
        }

        for (int j = 0; j < n; j++) {
            if (obstacle_array[j][0] == 1) {
                dp[j][0] = 0;
                break;
            }else
                dp[j][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacle_array[i][j] == 1) {
                    dp[i][j] = 0;
                }else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
