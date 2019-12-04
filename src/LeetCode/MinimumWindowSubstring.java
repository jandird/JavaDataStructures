package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> set = new HashMap<>();
        int c = t.length();

        int low = -1;
        int high = -1;
        int count = 0;

        int min = s.length() + 1;
        String minS = "";

        for (int i = 0; i < c; i++){
            if (set.containsKey(t.charAt(i))){
                set.put(t.charAt(i), set.get(t.charAt(i)) - 1);
            }
            else {
                set.put(t.charAt(i), - 1);
            }
        }

        int index = 0;
        while (low == -1){
            if (set.containsKey(s.charAt(index))){
                low = index;
                high = index;
                set.put(s.charAt(index), set.get(s.charAt(index)) + 1);
                count++;
            }
            index++;

            if (index == s.length() && low == -1){
                return "";
            }
        }

        while (high < s.length() - 1){
            if (count != c){
                high++;
                if (set.containsKey(s.charAt(high))){
                    if (set.get(s.charAt(high)) < 0){
                        count++;
                    }
                    set.put(s.charAt(high), set.get(s.charAt(high)) + 1);
                }
            }
            while (count == c){
                if (high - low + 1 <= min){
                    min = high-low+1;
                    minS = s.substring(low, high + 1);
                }
                if (set.containsKey(s.charAt(low))){
                    if (set.get(s.charAt(low)) == 0){
                        count--;
                    }
                    set.put(s.charAt(low), set.get(s.charAt(low)) - 1);
                }
                low++;
            }
        }

        if (count == c){
            if (high - low + 1 <= min){
                min = high-low+1;
                minS = s.substring(low, high + 1);
            }
        }

        return minS;
    }

}
