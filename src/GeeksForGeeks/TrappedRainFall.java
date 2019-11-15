package GeeksForGeeks;

import java.util.Scanner;

public class TrappedRainFall {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tests = in.nextInt();

        for (int i = 0; i < tests; i++){
            int n = in.nextInt();
            int [] arr = new int[n];

            for (int j = 0; j < n; j++){
                arr[j] = in.nextInt();
            }

            int p1 = 0;
            int p2 = 1;

            int max = 0;
            int maxp = 0;

            int count = 0;

            while (p1 < n - 1){

                if (p2 == n - 1){
                    int cur = arr[p1];
                    p1++;
                    if (max < cur){
                        while (p1 < maxp){
                            count += max - arr[p1];
                            p1++;
                        }
                    }
                    else {
                        while (p1 < maxp){
                            count += cur - arr[p1];
                            p1++;
                        }
                    }

                    break;
                }
                else if (arr[p2] < arr[p1]){
                    p2++;
                    if (arr[p2] > max){
                        max = arr[p2];
                        maxp = p2;
                    }
                }
                else {
                    int cur = arr[p1];
                    p1++;
                    while (p1 < p2){
                        count += cur - arr[p1];
                        p1++;
                    }
                    max = 0;
                    p2++;
                }
                System.out.println(count);
            }
            System.out.println(count);
        }
    }
}
