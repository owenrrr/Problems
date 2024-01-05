import java.util.*;

import lc_309.Solution;

public class Main {

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maxProfit(new int[]{1,2,3,0,2}));
    }

    public static void arrayFix(String str){
        str = str.replaceAll("\\[", "{");
        str = str.replaceAll("]", "}");
        str = str.replaceAll("\"", "'");
        System.out.println(str);
    }
}
