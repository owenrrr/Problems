package lc_213;

import java.util.Arrays;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int ans = 0;
        int[] max = new int[nums.length];
        max[0] = nums[0]; // take nums[0]
        max[1] = nums[0]; // not take nums[1]
        for (int i=2; i<nums.length; i++){
            if (i == nums.length - 1){
                max[i] = Math.max(max[i-2], max[i-1]);
                break;
            }
            max[i] = Math.max(max[i-2]+nums[i], max[i-1]);
        }
        ans = max[nums.length - 1];

        Arrays.fill(max, 0);
        max[0] = 0;
        max[1] = nums[1];
        for (int i=2; i<nums.length; i++){
            max[i] = Math.max(max[i-2]+nums[i], max[i-1]);
        }
        ans = Math.max(ans, max[nums.length - 1]);
        return ans;
    }
}
