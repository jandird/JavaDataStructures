package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuggestedProducts {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        String cur = Character.toString(searchWord.charAt(0));
        int index = -1;

        List<List<String>> ret = new ArrayList();

        boolean indexFound = false;

        while (!indexFound){
            index++;
            if (index >= products.length ||products[index].charAt(0) > searchWord.charAt(0)){
                for (int i = 0; i < searchWord.length(); i++){
                    ret.add(new ArrayList<String>());
                }
                return ret;
            }
            else if (products[index].charAt(0) == searchWord.charAt(0)){
                indexFound = true;
                ArrayList<String> temp = new ArrayList();
                for (int i = 0; i < 3; i++){
                    if (index + i < products.length && products[index + i].charAt(0) == searchWord.charAt(0)){
                        temp.add(products[index + i]);
                    }
                }
                ret.add(temp);
            }

        }

        index--;
        for (int i = 1; i < searchWord.length(); i++){
            indexFound = false;
            cur += searchWord.charAt(i);
            while (!indexFound){
                index++;

                if (index >= products.length || (products[index].length() > i && products[index].substring(0, i + 1).compareTo(cur) > 0)){
                    for (int j = i; j < searchWord.length(); j++){
                        ret.add(new ArrayList<String>());
                    }
                    return ret;
                }
                else if (products[index].length() > i && products[index].substring(0, i + 1).equals(cur)){
                    indexFound = true;
                    ArrayList<String> temp = new ArrayList();
                    for (int j = 0; j < 3; j++){
                        if (index + j < products.length && products[index + j].length() >= i + 1 && products[index + j].substring(0, i + 1).equals(cur)){
                            temp.add(products[index + j]);
                        }
                    }
                    ret.add(temp);
                    index--;
                }

            }
        }

        return ret;
    }
}
