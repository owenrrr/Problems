package lc_221;


public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] area = new int[m][n];
        area[0][0] = matrix[0][0] == '1' ? 1 : 0;
        int max = area[0][0];

        for (int i=1; i<m; i++){
            area[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(max, area[i][0]);
        }
        for (int j=1; j<n; j++){
            area[0][j] = matrix[0][j] == '1' ? 1 : 0;
            max = Math.max(max, area[0][j]);
        }

        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                if (matrix[i][j] == '1'){
                    if (area[i-1][j-1] == 0) area[i][j] = 1;
                    else if (area[i-1][j-1] < Math.min(area[i-1][j], area[i][j-1])) area[i][j] = area[i-1][j];
                    else area[i][j] = Math.min(area[i-1][j], area[i][j-1]) + 1;
                    max = Math.max(max, area[i][j] * area[i][j]);
                }
            }
        }
        return max;
    }
}
