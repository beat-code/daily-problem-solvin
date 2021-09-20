package leetcode_top_interview;

import java.util.HashMap;
import java.util.Map;

public class _2LongestSubstringWithoutRep {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max=1;
        Map<Character, Integer> map = new HashMap<>();
        int i=0,j=0;
        for(; j<s.length(); j++){
            char c = s.charAt(j);
            if(map.containsKey(c)){
               i = Math.max(i, map.get(c)+1);

            }
            map.put(c, j);
            max = Math.max(max, j-i+1);
        }
        return max;
    }
}
