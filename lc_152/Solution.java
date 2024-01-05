package lc_152;

public class Solution {
    public int maxProduct(int[] nums) {

        int left = 1, right = 1;
        int ans = Integer.MIN_VALUE;

        for (int i=0; i<nums.length; i++){

            left = left == 0 ? 1 : left;
            right = right == 0 ? 1 : right;

            left = left * nums[i];
            right = right * nums[nums.length-i-1];

            ans = Math.max(ans, Math.max(left, right));
        }
        return ans;
    }
}
