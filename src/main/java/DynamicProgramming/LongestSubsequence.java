package DynamicProgramming;

public class LongestSubsequence {
    public static void main(String[] args) {
        String str1 = "abcef";
        String str2 = "acde";
        int res = dynamicProgramming(str1, str2);
        System.out.println(res);
    }


    private static int dynamicProgramming(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int [][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                else
                    dp[i + 1] [j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[m][n];
    }
}
