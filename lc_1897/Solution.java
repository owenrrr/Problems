package lc_1897;

public class Solution {
    public boolean makeEqual(String[] words) {
        int len = words.length;
        int mod = 0;
        int[] letters = new int[26];
        for (String w: words){
            mod += w.length() % len;
        }
        if (mod % len != 0) return false;
        int letter = 97;
        for (String word: words){
            for (int i=0; i<word.length(); i++){
                letter = word.charAt(i);
                letters[letter - 97] = (letters[letter - 97] + 1) % len;
            }
        }
        for (int i=0; i<25; i++){
            if (letters[i] != 0) return false;
        }
        return true;
    }
}
