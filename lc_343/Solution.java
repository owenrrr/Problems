package lc_343;

public class Solution {
    public int integerBreak(int n) {
        if (n <= 5){
            int[] t = new int[]{1,2,4,6};
            return t[n-2];
        }
        int[] ans = new int[]{4,6,9};
        int count = n - 5, tmp;
        while (--count > 0){
            tmp = ans[0] * 3;
            ans[0] = ans[1];
            ans[1] = ans[2];
            ans[2] = tmp;
        }
        return ans[2];
    }
}
