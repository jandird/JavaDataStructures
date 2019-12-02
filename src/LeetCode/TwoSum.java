package LeetCode;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int N = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++){
            map.put(nums[i], i);
        }

        for (int i = 0; i < N; i++){
            if (map.containsKey(target - nums[i])){
                int j = map.get(target-nums[i]);

                if (i != j){
                    return new int[] {i, j};
                }
            }
        }

        return new int[] {0, 0};
    }
}
