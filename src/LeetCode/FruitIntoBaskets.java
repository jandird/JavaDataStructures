package LeetCode;

public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        int maxCount = 0;

        if (tree.length == 1){
            return 1;
        }

        if (tree.length == 2){
            return 2;
        }

        for (int i = 0; i+1 < tree.length; i++){
            int count = 2;

            int f1 = tree[i];
            int f2 = tree[i+1];

            for (int j = i+2; j < tree.length; j++){
                if (tree[j] == f1 || tree[j] == f2){
                    count++;
                }
                else if (f1 == f2){
                    f2 = tree[j];
                    count++;
                }
                else {break;}
            }

            if (count > maxCount){
                maxCount = count;
            }
        }

        return maxCount;
    }
}
