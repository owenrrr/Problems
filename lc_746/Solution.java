package lc_746;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] current_min_cost = new int[len];
        current_min_cost[0] = cost[0];
        current_min_cost[1] = cost[1];

        for (int i=2; i<len; i++){
            current_min_cost[i] = Math.min(current_min_cost[i-1], current_min_cost[i-2]) + cost[i];
        }
        return Math.min(current_min_cost[len-1], current_min_cost[len-2]);
    }
}
