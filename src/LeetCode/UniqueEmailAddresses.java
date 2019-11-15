package LeetCode;

import java.util.HashMap;

public class UniqueEmailAddresses {
    static public int numUniqueEmails(String[] emails) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int count = 0;

        for (String s : emails) {
            String email = s;
            String first = email.substring(0, email.indexOf("@"));
            first = first.replaceAll("\\.", "");

            if (first.contains("+")) {
                first = first.substring(0, first.indexOf("+"));
            }

            email = first + email.substring(email.indexOf("@"));
            if (!hashMap.containsKey(email)) {
                hashMap.put(email, 0);
                count++;
            }
        }

        return count;
    }
}
