package LeetCode;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        boolean[] check = new boolean[nums.length + 1];

        for (int num : nums) {
            check[num] = true;
        }

        for (int i = 0; i < nums.length; i++){
            if (!check[i]){
                return i;
            }
        }

        return nums.length;
    }
}
