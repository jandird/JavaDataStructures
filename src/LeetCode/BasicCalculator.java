package LeetCode;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Character> op = new Stack<>();
        Stack<Integer> num = new Stack<>();
        String n = "";
        boolean p = false;

        op.push('+');

        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if ((int)cur >= 48 && (int)cur <= 57){
                p = true;
                n += cur;
            }
            else if (p){
                num.push(Integer.parseInt(n));
                p = false;
                n = "";
            }

            if ((p && i == s.length() - 1)){
                num.push(Integer.parseInt(n));
            }

            if (cur == ' '){
                continue;
            }
            else if (cur == ')'){
                int temp;
                char oper = op.pop();

                if (oper == '-'){
                    temp = num.pop() * -1;
                }
                else {
                    temp = num.pop();
                }

                while (oper != '('){
                    oper = op.pop();
                    if (oper == '-'){
                        temp -= num.pop();
                    }
                    else {
                        temp += num.pop();
                    }
                }
                System.out.println(temp);
                num.push(temp);
            }
            else if (cur == '(' || cur == '+' || cur == '-') {
                op.push(cur);
            }
        }

        int ret;
        char oper = op.pop();

        if (oper == '-'){
            ret = num.pop() * -1;
        }
        else {
            ret = num.pop();
        }

        if (!op.empty()){
            oper = op.pop();
        }

        while (!num.empty()){
            if (oper == '-'){
                ret -= num.pop();
            }
            else {
                ret += num.pop();
            }
            if (!op.empty()){
                oper = op.pop();
            }
            else {
                oper = '+';
            }
        }

        return ret;
    }
}
