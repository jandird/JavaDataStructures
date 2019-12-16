package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public static void main(String[] args) {
        int[] arr = {2147483647};
        System.out.println(findMissingRanges(arr, -2147483648, 2147483647).get(0));
    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> ret = new ArrayList<>();

        for (int i = -1; i < nums.length; i++){
            long a;
            long b;

            if (nums.length == 0){
                a = (long)lower - 1;
                b = (long)upper + 1;
            }
            else if (i == -1){
                a = (long)lower - 1;
                b = (long)nums[0];
            }
            else if (i == nums.length - 1){
                a = (long)nums[i];
                b = (long)upper + 1;
            }
            else {
                a = (long)nums[i];
                b = (long)nums[i + 1];
            }

            System.out.println(a);
            System.out.println(b);
            long sub = b - a;
            if (sub == 2){
                ret.add(Long.toString(a+1));
            }
            else if (sub > 2){
                StringBuilder s = new StringBuilder();
                s.append(a + 1).append("->").append(b - 1);
                ret.add(s.toString());
            }
        }
        return ret;
    }
}
