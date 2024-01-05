package lc_131;

import java.util.ArrayList;
import java.util.List;

/**
 *         Solution sol = new Solution();
 *         System.out.println(sol.partition("aab"));
 */
public class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> current = new ArrayList<>();
    public List<List<String>> partition(String s) {
        recur(s, 0);
        return ans;
    }

    public void recur(String str, int start){
        if (start >= str.length()){
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i=start; i<str.length(); i++){
            if (isPalindrome(str, start, i)){
                current.add(str.substring(start, i+1));
                recur(str, i+1);
                current.remove(current.size()-1);
            }
        }
    }

    public boolean isPalindrome(String str, int low, int high){
        while (low < high){
            if (str.charAt(low++) != str.charAt(high--)) return false;
        }
        return true;
    }
}
