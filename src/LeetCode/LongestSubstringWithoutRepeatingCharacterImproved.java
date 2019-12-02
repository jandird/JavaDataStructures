package LeetCode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacterImproved {
    public int lengthOfLongestSubstring(String s) {

        int N = s.length();

        if (N == 0){
            return 0;
        }

        int max = 1;
        int i = 0;
        int j = 1;

        HashMap<Character, Integer> seen = new HashMap<>();
        seen.put(s.charAt(i), i);
        while (j < N){
            if (!seen.containsKey(s.charAt(j))){
                seen.put(s.charAt(j), j);
                j++;
            }
            else {
                max = Math.max(max, j - i);
                i = seen.get(s.charAt(j)) ;
                j++;
                seen = new HashMap<>();
                seen.put(s.charAt(i), i);
            }
        }

        return max;
    }
}
