package lc_122;

/**
 *         int[] prices = new int[]{7,1,5,3,6,4};
 *         Solution sol = new Solution();
 *         System.out.println(sol.maxProfit(prices));
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int profits = 0;
        int min = Math.min(prices[0], prices[1]);
        if (prices[1] > prices[0]){
            min = prices[1];
            profits = prices[1] - prices[0];
        }
        for (int i=2; i<prices.length; i++){
            if (prices[i] > min){
                profits += prices[i] - min;
            }
            min = prices[i];
        }
        return profits;
    }
}