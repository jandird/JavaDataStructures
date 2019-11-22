package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxDominoSum {
    public int solution(int[] A, int[] B, int K) {
        int N = A.length;

        int [] diff = new int[11];

        int aSum = 0;
        int bSum = 0;

        for (int i = 0; i < N; i++){
            aSum += A[i];
            bSum += B[i];

            diff[A[i] - B[i] + 5]++;
        }

        if (aSum <= bSum){
            for (int i = 5; i >= 1; i--){
                if (diff[i+5] >= K){
                    aSum += i*K;
                    return aSum;
                }
                else {
                    aSum += i*diff[i+5];
                    K -= diff[i+5];
                }
            }

            return aSum;
        }
        else {
            for (int i = 5; i >= 1; i--){
                if (diff[i-5] >= K){
                    bSum += i*K;
                    return bSum;
                }
                else {
                    bSum += i*diff[i-5];
                    K -= diff[i-5];
                }
            }

            return bSum;
        }
    }
}
