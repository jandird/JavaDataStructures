package LeetCode;

import java.util.Arrays;

public class NextPermutation {
    public int[] nextPermutation(int[] nums) {

        for (int i = nums.length - 1; i >= 0; i--){
            if (i == 0){
                return reverseEnd(nums, 0, nums.length - 1);
            }
            else if (nums[i - 1] < nums[i]){
                int low = nums[i - 1];
                for (int j = i; j < nums.length; j++){
                    if (j == nums.length - 1){
                        nums[i - 1] = nums[j];
                        nums[j] = low;

                        if (nums.length - i > 2){
                            return reverseEnd(nums, i, nums.length);
                        }
                        else {
                            return nums;
                        }
                    }
                    else if (nums[j + 1] < nums[j]){
                        nums[i - 1] = nums[j + 1];
                        nums[j + 1] = low;

                        if (nums.length - i > 2){
                            return reverseEnd(nums, i, nums.length);
                        }
                        else {
                            return nums;
                        }
                    }
                }
            }
        }
        return nums;
    }

    public int[] reverseEnd(int[] r, int a, int b){
        int[] n = r;
        for (int i = 0; i >= b - a; i--){
            n[a+i] = r[b-i];
        }

        return n;
    }
}
