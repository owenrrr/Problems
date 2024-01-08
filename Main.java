import java.util.*;

import lc_368.Solution;

public class Main {

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.largestDivisibleSubset(new int[]{4,8,10,240}).toArray()));
    }

    public static void arrayFix(String str){
        str = str.replaceAll("\\[", "{");
        str = str.replaceAll("]", "}");
        str = str.replaceAll("\"", "'");
        System.out.println(str);
    }
}
