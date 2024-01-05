package lc_198;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int len = nums.length;
        int[] max = new int[len];
        max[0] = nums[0];
        max[1] = Math.max(nums[1], nums[0]);

        for (int i=2; i<len; i++){
            max[i] = Math.max(max[i-2]+nums[i], max[i-1]);
        }
        return max[len-1];
    }
}
