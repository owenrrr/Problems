package lc_1268;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        PriorityQueue<String> queue = new PriorityQueue<>(3, String::compareTo);
        List<List<String>> ans = new ArrayList<>();

        String temp;
        for (int i=1; i<=searchWord.length(); i++){
            temp = searchWord.substring(0, i);
            for (String s: products){
                if (s.startsWith(temp)){
                    queue.offer(s);
                }
            }

            List<String> tmp = new ArrayList<>();
            for (int j=0; j<3; j++){
                if (queue.peek() != null){
                    tmp.add(queue.poll());
                }
            }
            queue.clear();
            ans.add(tmp);
        }

        return ans;
    }
}
