package LeetCode;

public class FlowerGardeners {

    public int solution(int[] plants, int capacity) {

        int N = plants.length;

        if (N == 1){
            return 1;
        }

        int count = 1;

        int can1 = capacity;
        int can2 = capacity;

        for (int i = 0; i < N / 2; i++){
            if (plants[i] <= can1 && plants[N - 1 - i] <= can2){
                can1 -= plants[i];
                can2 -= plants[N - 1 - i];
            }
            else {
                count++;
                can1 = capacity - plants[i];
                can2 = capacity - plants[N - 1 - i];
            }
        }

        if (N % 2 == 1){
            if (can1 + can2 < plants[N / 2]){
                count++;
            }
        }

        return count;
    }
}
