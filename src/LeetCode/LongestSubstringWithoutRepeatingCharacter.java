package LeetCode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }

        int max = 1;

        for (int i = 0; i < s.length(); i++){
            int cur = 1;
            HashMap <Character, Integer> hash = new HashMap<>();
            hash.put(s.charAt(i), 1);

            for (int j = i+1; j < s.length(); j++){
                if (!hash.containsKey(s.charAt(j))){
                    cur++;
                    hash.put(s.charAt(j), 1);
                }
                else {
                    break;
                }
            }
            if (cur > max){
                max = cur;
            }
        }

        return max;
    }
}
