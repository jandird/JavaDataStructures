package LeetCode;

import java.util.Arrays;

public class SearchMatrixTwo {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;

        if (m == 0){
            return false;
        }

        int n = matrix[0].length;

        if (n == 0){
            return false;
        }

        for (int i = 0; i < m; i++){
            if (target >= matrix[i][0] && target <= matrix[i][n-1]){
                if (Arrays.binarySearch(matrix[i], target) >= 0){
                    return true;
                }
            }
        }

        return false;
    }
}
