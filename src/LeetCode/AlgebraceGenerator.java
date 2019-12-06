package LeetCode;

import java.util.Random;

public class AlgebraceGenerator {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            StringBuilder s = new StringBuilder();
            //("3 + x = 20", ("16", "31", "17"), 2),

            Random random = new Random();
            int op = random.nextInt(3);
            int a = random.nextInt(21);

            s.append("(\"");
            s.append(a);

            if (op == 0) {
                s.append(" + x = ");
                int b = random.nextInt(21);
                int ans = b - a;
                s.append(b);
                s.append("\", (\"");
                int mc = random.nextInt(3);

                if (mc == 0) {
                    s.append(ans + "\", \"" + (ans - (random.nextInt(10) + 1)) + "\", \"" + (ans + (random.nextInt(10) + 1)) + "\"), 0),");
                } else if (mc == 1) {
                    s.append((ans - (random.nextInt(10) + 1)) + "\", \"" + ans + "\", \"" + (ans + (random.nextInt(10) + 1)) + "\"), 1),");
                } else {
                    s.append((ans - (random.nextInt(10) + 1)) + "\", \"" + (ans + (random.nextInt(10) + 1)) + "\", \"" + ans + "\"), 2),");
                }
            }
            if (op == 1) {
                s.append(" - x = ");
                int b = random.nextInt(21);
                int ans = a - b;
                s.append(b);
                s.append("\", (\"");
                int mc = random.nextInt(3);

                if (mc == 0) {
                    s.append(ans + "\", \"" + (ans - (random.nextInt(10) + 1)) + "\", \"" + (ans + (random.nextInt(10) + 1)) + "\"), 0),");
                } else if (mc == 1) {
                    s.append((ans - (random.nextInt(10) + 1)) + "\", \"" + ans + "\", \"" + (ans + (random.nextInt(10) + 1)) + "\"), 1),");
                } else {
                    s.append((ans - (random.nextInt(10) + 1)) + "\", \"" + (ans + (random.nextInt(10) + 1)) + "\", \"" + ans + "\"), 2),");
                }
            }
            if (op == 2) {
                s.append("x = ");
                int b = (random.nextInt(5) + 1);
                int ans = b;
                s.append(a * b);
                s.append("\", (\"");
                int mc = random.nextInt(3);

                if (mc == 0) {
                    s.append(ans + "\", \"" + (ans - (random.nextInt(5) + 1)) + "\", \"" + (ans + (random.nextInt(5) + 1)) + "\"), 0),");
                } else if (mc == 1) {
                    s.append((ans - (random.nextInt(10) + 1)) + "\", \"" + ans + "\", \"" + (ans + (random.nextInt(10) + 1)) + "\"), 1),");
                } else {
                    s.append((ans - (random.nextInt(10) + 1)) + "\", \"" + (ans + (random.nextInt(10) + 1)) + "\", \"" + ans + "\"), 2),");
                }
            }

            System.out.println(s.toString());
        }
    }
}
