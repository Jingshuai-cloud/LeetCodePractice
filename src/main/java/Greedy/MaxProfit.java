package Greedy;

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {2,3,1,5,7};
        int maxProfit = greedyProfit(prices);
        System.out.println(maxProfit);
    }

    private static int greedyProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }
}
