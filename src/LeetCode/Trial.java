package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class Trial {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        s1.push(0);
        s1.push(10);

        s2.push(0);
        s2.push(11);

        System.out.println(s1.equals(s2));
    }

}
