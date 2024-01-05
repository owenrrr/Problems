package lc_452;

import java.util.Arrays;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));

        int ans = 1;
        int previous = 0;

        for (int i=0; i<points.length; i++){
            if (points[i][0] > points[previous][1]){
                ans ++;
                previous = i;
            }
        }
        return ans;
    }
}
