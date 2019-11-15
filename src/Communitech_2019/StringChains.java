package Communitech_2019;

import java.util.HashMap;
import java.util.List;

public class StringChains {
    public static void main(String[] args) {

        String cur = "ab";

        for (int i = 0; i < cur.length(); i++){
            String test = cur.substring(0, i) + cur.substring(i + 1, cur.length());
            System.out.println(test);
        }
    }

    public static int longestChain(List<String> words) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<Integer, Integer> sizeMap = new HashMap<>();

        int size = 1;
        int count = 0;
        for (String cur : words){
            if (cur.length() > size){
                sizeMap.put(size, count);
                size++;
            }
            else if (cur.length() == size){
                count++;
            }
        }



        for (String cur : words){
            if (cur.length() > 1){
                hashMap.put(cur, 0);
                for (int i = 0; i < cur.length(); i++){
                    String test = cur.substring(0, i) + cur.substring(i + 1, cur.length());
                    for (int j = hashMap.get(cur.length() - 1); j < hashMap.get(cur.length()); j++){
                        if (test.equals(words.get(j))){
                            if (hashMap.get(words.get(j)) + 1 > hashMap.get(cur)){
                                hashMap.put(cur, hashMap.get(words.get(j)));
                            }
                        }
                    }
                }
            }
            else {
                hashMap.put(cur, 0);
            }
        }

        int max = 0;
        for (String cur: words){
            if (hashMap.get(cur) > max){
                max = hashMap.get(cur);
            }
        }

        return max;
    }
}
