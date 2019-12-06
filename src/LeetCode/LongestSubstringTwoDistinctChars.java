package LeetCode;

public class LongestSubstringTwoDistinctChars {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int N = s.length();

        if (N <= 2){
            return N;
        }

        int i = 0;
        int j = 1;

        char a = s.charAt(0);
        char b = ' ';

        while (j < N && b == ' '){
            if (s.charAt(j) != a){
                b = s.charAt(j);
            }
            else {
                j++;
            }

            if (j == N){
                return N;
            }
        }

        int loc = j;

        int max = 2;

        while (j < N - 1){
            j++;
            char cur = s.charAt(j);

            if (cur == a || cur == b){
                if (cur != s.charAt(j - 1)){
                    loc = j;
                }
            }
            else {
                if (s.charAt(loc) == a){
                    b = cur;
                }
                else {
                    a = cur;
                }
                max = Math.max(max, j - i);

                i = loc;
                loc = j;

            }
        }

        return Math.max(max, j - i + 1);
    }
}
