package LeetCode;

import java.util.Scanner;

public class LabOneParser {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        in.nextLine();
        in.nextLine();

        String request = in.nextLine().split(":")[1];

        in.nextLine();

        String host = in.nextLine().replace("\\r\\n", "").split(":")[1];

        String completeRequestURL = host + request;
    }
}
