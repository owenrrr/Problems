package lc_322;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] needed_numbers = new int[amount + 1];
        Arrays.fill(needed_numbers, -1);
        needed_numbers[0] = 0;
        int min = -2;   // default needed_numbers[i] = -2 + 1 = -1

        for (int i=1; i<=amount; i++){
            for (int coin: coins){
                if (i - coin >= 0 && needed_numbers[i-coin] != -1){
                    if (min == -2) min = needed_numbers[i-coin];
                    else min = Math.min(needed_numbers[i-coin], min);
                }
            }
            needed_numbers[i] = min + 1;
            min = -2;
        }
        return needed_numbers[amount];
    }
}
