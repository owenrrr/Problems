package lc_338;

public class Solution {
    public int[] countBits(int n) {
        int count = 0, tmp = 0;
        int[] ans = new int[n + 1];
        for (int i=1; i<=n; i++){
            if (i % 2 == 0){
                ans[i] = ans[i / 2];
                continue;
            }
            tmp = i;
            while (tmp >= 1){
                if (tmp <= 2){
                    count++;
                    break;
                }
                count += (tmp % 2);
                tmp = tmp / 2;
            }
            ans[i] = count;
            count = 0;
        }
        return ans;
    }
}
