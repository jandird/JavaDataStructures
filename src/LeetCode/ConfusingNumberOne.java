package LeetCode;

public class ConfusingNumberOne {
    public boolean confusingNumber(int N) {
        StringBuilder r = new StringBuilder();
        String n = Integer.toString(N);

        for (int i = n.length() - 1; i >= 0; i--){
            char c = n.charAt(i);
            if (c == '9'){
                r.append('6');
            }
            else if (c == '6'){
                r.append('9');
            }
            else if (c == '0' || c == '1' || c == '8'){
                r.append(c);
            }
            else {
                return false;
            }
        }

        if (N != Integer.parseInt(r.toString())){
            return true;
        }

        return false;
    }
}
