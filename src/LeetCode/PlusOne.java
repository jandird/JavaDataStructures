package LeetCode;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int N = digits.length;

        digits[N-1] = digits[N-1] + 1;

        if (digits[N-1] <= 9){

            return digits;
        }

        for (int i = N - 1; i >= 0; i--){
            if (i == 0 && digits[i] > 9){
                int[] n = new int[N + 1];
                n[0] = 1;
                return n;
            }
            if (digits[i] > 9){
                digits[i] = 0;
                digits[i - 1] = digits[i - 1] + 1;
            }
            else {
                return digits;
            }
        }

        return digits;
    }
}
