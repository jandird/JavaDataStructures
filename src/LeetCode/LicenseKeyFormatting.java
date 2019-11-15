package LeetCode;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {

        S = S.replaceAll("-", "");

        int first = S.length()%K;

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < S.length(); i++){

            int c = S.charAt(i);

            if (c >= 97 && c<= 122){
                c -= 32;
            }

            s.append((char) c);

            if (i+1 == first && first != 0 && i+1 < S.length()){
                s.append("-");
            }
            else if (i+1 > first && (i+1-first)%K == 0 && i+1 < S.length()){
                s.append("-");
            }
        }

        return s.toString();
    }
}
