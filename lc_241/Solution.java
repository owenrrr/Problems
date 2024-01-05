package lc_241;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        // simplify expression into one specific pattern: A operator B
        List<Integer> total = new ArrayList<>();
        for (int i=0; i<expression.length(); i++){
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for (int l: left){
                    for (int r: right){
                        if (ch == '+') total.add(l+r);
                        else if (ch == '-') total.add(l-r);
                        else total.add(l*r);
                    }
                }
            }
        }
        if (total.isEmpty()) total.add(Integer.parseInt(expression));
        return total;
    }
}
