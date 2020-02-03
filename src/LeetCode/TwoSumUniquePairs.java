package LeetCode;

import java.util.HashSet;

public class TwoSumUniquePairs {
    public int twoSumUnique(int[] arr, int target){
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> seen = new HashSet<>();

        for (int i : arr){
            set.add(i);
        }

        int count = 0;
        for (int i : arr){
            int currentTarget = target - i;

            if (set.contains(currentTarget) && !seen.contains(currentTarget) && !seen.contains(i)){
                seen.add(currentTarget);
                seen.add(i);
                count++;
            }
        }

        return count;
    }
}
