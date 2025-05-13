import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504_괄호의값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(getNum(s));
    }

    static int getNum(String s){
        Stack<Character> stack = new Stack<>();
        int answer =0;
        int count = 1;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                count *=2;
                stack.push('(');
            }else if (s.charAt(i) == '[') { // 여는 괄호면 곱셈
                count *= 3;
                stack.push('[');
            }else if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return 0;
                } else if (s.charAt(i - 1) == '(') {
                    answer += count;
                }
                stack.pop();
                count /=2;
            }else if(s.charAt(i) == ']'){
                if (stack.isEmpty() || stack.peek() != '[') {
                    return 0;
                } else if (s.charAt(i - 1) == '[') {
                    answer += count;
                }
                stack.pop();
                count /=3;
            }

        }

        if(!stack.isEmpty()) return 0;
        return answer;
    }
}
