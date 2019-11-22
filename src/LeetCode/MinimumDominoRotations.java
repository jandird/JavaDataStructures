package LeetCode;

public class MinimumDominoRotations {
    public static int minDominoRotations(int[] A, int[] B) {
        int [] totalCount = new int[6];
        int [] aCount = new int[6];
        int [] bCount = new int[6];

        for (int i = 0; i < A.length; i++){
            int a = A[i];
            int b = B[i];

            if (a == b){
                totalCount[a - 1]++;
            }
            else {
                totalCount[a - 1]++;
                totalCount[b - 1]++;

                aCount[a - 1]++;
                bCount[b - 1]++;
            }
        }

        int minRot = A.length + 1;

        for (int i = 0; i < totalCount.length; i++){
            if (totalCount[i] == A.length){
                int rotations = Math.min(aCount[i], bCount[i]);

                if (rotations < minRot){
                    minRot = rotations;
                }
            }
        }

        if (minRot <= A.length){
            return minRot;
        }
        else {
            return - 1;
        }
    }

    public static void main(String[] args) {
        int [] A = {3,5,1,2,3};
        int [] B = {3,6,3,3,4};

        System.out.println(minDominoRotations(A, B));
    }
}
