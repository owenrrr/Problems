package lc_2870;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums){
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }

        int count = 0, n = 0;
        for (Map.Entry<Integer, Integer> m: map.entrySet()){
            n = m.getValue();
            if (n == 1) return -1;
            if (n % 3 == 0){
                count += n / 3;
            }else{
                count += (n / 3) + 1;
            }
        }
        return count;
    }
}
