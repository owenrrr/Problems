package lc_1137;

public class Solution {
    public int tribonacci(int n) {
        int[] init = new int[]{0,1,1};
        if (n <= 2) return init[n];

        int cur = 2, tmp = 0;
        while (n > cur){
            tmp = init[0] + init[1] + init[2];
            init[0] = init[1];
            init[1] = init[2];
            init[2] = tmp;

            cur++;
        }
        return init[2];
    }
}
