package lc_139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *         List<String> dict = new ArrayList<>();
 *         dict.add("apple");
 *         dict.add("pen");
 *         Solution sol = new Solution();
 *         System.out.println(sol.wordBreak("applepenapple", dict));
 */
public class Solution {
//    boolean fit = false;
//    public boolean wordBreak(String s, List<String> wordDict) {
//        recur(s, 0, wordDict);
//        return fit;
//    }
//
//    public void recur(String s, int start, List<String> wordDict){
//        if (start == s.length()){
//            fit = true;
//            return;
//        }
//        for (int i=start; i<s.length(); i++){
//            if (wordDict.contains(s.substring(start, i+1))){
//                recur(s, i+1, wordDict);
//            }
//        }
//    }

    public boolean wordBreak(String s, List<String> wordDict){
        boolean [] dp=new boolean[s.length()+1];
        dp[0]=true;
        Set<String> set=new HashSet<>(wordDict);
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                String suffix=s.substring(j,i);
                if(set.contains(suffix) && dp[j]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
