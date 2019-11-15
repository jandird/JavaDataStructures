package Communitech_2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DigitSum {
    public static void main(String[] args) {
        long a = 0;
        long b = 20;

        HashMap<Long, Long> hashMap = new HashMap<>();
        hashMap.put((long)1, (long)0);
        hashMap.put((long)2, (long)0);
        hashMap.put((long)3, (long)0);
        hashMap.put((long)4, (long)0);
        hashMap.put((long)5, (long)0);
        hashMap.put((long)6, (long)0);
        hashMap.put((long)7, (long)0);
        hashMap.put((long)8, (long)0);
        hashMap.put((long)9, (long)0);

        for (long i = a; i < b; i++){
            String num = Long.toString(i);
            long sum = 0;
            boolean done = true;
            for (int j = 0; j < num.length(); j++){
                sum += (long)num.charAt(j);
                if (sum > 9){
                    done = false;
                    break;
                }
            }
            if (done) {
                hashMap.put(sum, hashMap.get(sum) + 1);
            }
        }

        long max = 0;
        for (long i = 1; i <= 9; i++){
            if (hashMap.get(i) > max){
                max = i;
            }
        }

        List<Long> list = new ArrayList<>();
        list.add((long)1);
        list.add(max);

    }
}
