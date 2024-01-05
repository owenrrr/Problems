package lc_1335;

public class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (d > jobDifficulty.length) return -1;
        int len = jobDifficulty.length;
        int[] left2right = new int[len];
        int[] right2left = new int[len];
        int[] delta = new int[len];

        left2right[0] = jobDifficulty[0];
        right2left[0] = jobDifficulty[len - 1];

        for (int i=1; i<len; i++){
            left2right[i] = Math.max(left2right[i - 1], jobDifficulty[i]);
            right2left[len-1-i] = Math.max(left2right[len - i], jobDifficulty[len-1-i]);
        }
        for (int i=0; i<len; i++){
            delta[i] = Math.abs(left2right[i] - right2left[i]);
        }
        boolean[] visited = new boolean[len];
        int ans = 0;
        return ans;

    }
}
