package LeetCode;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        int N = nums.length;
        ArrayList<List<Integer>> ret = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < N - 2; i++){
            if (nums[i] > 0){
                break;
            }

            if (i == 0 || (nums[i - 1] != nums[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int j = i + 1; j < N; j++){
                    if (!map.containsKey(nums[j])){
                        map.put(nums[j], 1);
                    }
                    else {
                        map.put(nums[j], map.get(nums[j]) + 1);
                    }
                }

                int sum = 0 - nums[i];
                int high = 0;
                for (int j = i + 1; j < N; j++){

                    if (map.get(nums[j]) == 1) {
                        map.remove(nums[j]);
                    } else {
                        map.put(nums[j], map.get(nums[j]) - 1);
                    }

                    if (j == i + 1 || nums[j-1] != nums[j]) {
                        if (map.containsKey(sum - nums[j])) {
                            Integer[] temp = {nums[i], nums[j], sum - nums[j]};
                            ret.add(Arrays.asList(temp));
                        }
                    }
                }
            }
        }

        return ret;
    }
}
