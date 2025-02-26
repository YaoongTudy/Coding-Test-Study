import java.util.*;
import java.io.*;

public class Main {
    static ArrayDeque<Character> stack = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int temp = 1;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                temp *= 2;
                stack.push('(');
            } else if (s.charAt(i) == '[') {
                temp *= 3;
                stack.push('[');
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    System.exit(0);
                } else if (i - 1 >= 0 && s.charAt(i - 1) == '(') {
                    ans += temp;
                }

                stack.pop();
                temp /= 2;
            } else if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    System.exit(0);
                } else if (i - 1 >= 0 && s.charAt(i - 1) == '[') {
                    ans += temp;
                }

                stack.pop();
                temp /= 3;
            }

        }

        if (!stack.isEmpty()) {
            System.out.println(0);
            System.exit(0);
        }

        System.out.println(ans);
    }
}
