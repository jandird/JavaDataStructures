package LeetCode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        int N = height.length;

        if (N == 2){
            return Math.min(height[0], height[1]);
        }

        int i = 0;
        int j = N - 1;

        int max = Math.min(height[i], height[j]) * (j - i);

        while (i != j){
            if (height[i] <= height[j]){
                i++;
                int cur = Math.min(height[i], height[j]) * (j - i);
                if (cur > max){
                    max = cur;
                }
            }
            else {
                j--;
                int cur = Math.min(height[i], height[j]) * (j - i);
                if (cur > max){
                    max = cur;
                }
            }
        }

        return max;
    }
}
