package LeetCode;

public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int ret [][] = new int[n][n];
        int c = 1;
        n = n - 1;

        for (int i = 0; i <= n / 2; i++){
            int x = i;
            int y = i;

            do {
                System.out.println(x + "," + y);

                ret[y][x] = c;
                c++;

                if ((n + 1) % 2 == 1 && n / 2 == x && n / 2 == y){
                    return ret;
                }
                else if (x == i && y == i){
                    x++;
                }
                else if (x == n - i && y == i){
                    y++;
                }
                else if (y == n - i && x == n - i){
                    x--;
                }
                else if (x == i && y == n - i){
                    y--;
                }
                else if (y == i){
                    x++;
                }
                else if (y == n - i){
                    x--;
                }
                else if (x == n - i){
                    y++;
                }
                else if (x == i){
                    y--;
                }

            }
            while (x != i || y != i);
        }

        return ret;
    }
}
