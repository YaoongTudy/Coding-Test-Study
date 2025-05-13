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

            if (s.charAt(i) == '(') { // 여는 괄호면 곱셈
                temp *= 2;
                stack.push('(');
            } else if (s.charAt(i) == '[') { // 여는 괄호면 곱셈
                temp *= 3;
                stack.push('[');
            } else if (s.charAt(i) == ')') { // 닫는 괄호면 나눗셈
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    System.exit(0);
                } else if (i - 1 >= 0 && s.charAt(i - 1) == '(') { // ()이면 덧셈
                    ans += temp;
                }

                stack.pop();
                temp /= 2;
            } else if (s.charAt(i) == ']') { // 닫는 괄호면 나눗셈 
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    System.exit(0);
                } else if (i - 1 >= 0 && s.charAt(i - 1) == '[') { // []면 덧셈
                    ans += temp;
                }

                stack.pop();
                temp /= 3;
            }

        }

        if (!stack.isEmpty()) { // 스택이 비어있다면 종료
            System.out.println(0);
            System.exit(0);
        }

        System.out.println(ans);
    }
}
