package lc_1624;

import java.util.Arrays;

public class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        int tmp = 0;
        int ans = -1;

        Arrays.fill(a1, -1);
        Arrays.fill(a2, -1);

        for (int i=0; i<s.length(); i++){
            tmp = s.charAt(i) - 'a';
            if (a1[tmp] == -1){
                a1[tmp] = i;
            }else{
                a2[tmp] = i;
                ans = Math.max(ans, a2[tmp] - a1[tmp] - 1);
            }
        }
        return ans;
    }
}
