package lc_1318;

public class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        boolean a1 = false, b1 = false, c1 = false;
        while (a > 0 || b > 0 || c > 0){
            if (a % 2 == 1) a1 = true;
            if (b % 2 == 1) b1 = true;
            if (c % 2 == 1) c1 = true;
            if (c1 && !(a1 || b1)){
                count++;
            }
            if (!c1){
                if (a1 && b1) count += 2;
                else if (a1 || b1) count++;
            }
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
            a1 = false;
            b1 = false;
            c1 = false;
        }
        return count;
    }
}
