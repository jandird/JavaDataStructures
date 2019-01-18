import java.util.HashMap;

public class HashMapStructure {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("Test", 1);
        System.out.println(hashMap.get("Test"));
        hashMap.remove("Test");
        System.out.println(hashMap.get("Test"));
        System.out.println(hashMap.size());
    }
}
