package lc_2125;

public class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank[0].length();
        int m = bank.length;

        int prev = 0, current = 0, beams = 0;
        for (int i=0; i<n; i++){
            if (bank[0].charAt(i) == '1') prev++;
        }
        for (int j=1; j<m; j++){
            for (int i=0; i<n; i++){
                if (bank[j].charAt(i) == '1') current++;
            }
            if (current != 0){
                beams += prev * current;
                prev = current;
                current = 0;
            }
        }
        return beams;
    }
}
