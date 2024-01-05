package lc_790;

public class Solution {
    public final int modulo = 1000000007;

    public int numTilings(int n) {
        if (n == 1) return 1;
        int[] A = new int[n + 1];
        int[] BC = new int[n + 1];
        A[1] = 1;
        A[2] = 2;
        BC[1] = 0;
        BC[2] = 1;
        for (int i=3; i<=n; i++){
            A[i] = (A[i-1] + A[i-2] + 2 * BC[i-1]) % modulo;
            BC[i] = (A[i-2] + BC[i-1]) % modulo;
        }
        System.out.println(Integer.MAX_VALUE);
        return A[n];
    }
}
