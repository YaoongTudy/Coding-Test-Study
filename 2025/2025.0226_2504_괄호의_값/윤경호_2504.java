import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();

        Stack<Character> stack = new Stack<>();
        int[] dp = new int[31]; // 깊이 t에서의 누적 점수를 저장
        boolean stackcheck = true;

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);

            // 여는 괄호: 스택에 추가
            if (c == '(' || c == '[') {
                stack.push(c);
            }
            // 닫는 괄호: 점수 계산 및 상위 레벨로 합산
            else if (c == ')' || c == ']') {
                if (stack.isEmpty()) {
                    stackcheck = false;
                    break;
                }

                char top = stack.pop();
                int currentDepth = stack.size() + 1; // 현재 닫힌 괄호의 깊이

                // 괄호 쌍이 맞지 않으면 오류
                if ((c == ')' && top != '(') || (c == ']' && top != '[')) {
                    stackcheck = false;
                    break;
                }

                // 기본 점수 설정
                int value = (c == ')') ? 2 : 3;

                // 내부 점수가 있으면 배수 적용
                if (dp[currentDepth] > 0) {
                    value *= dp[currentDepth];
                    dp[currentDepth] = 0; // 내부 점수 초기화
                }

                // 상위 레벨로 점수 합산
                if (stack.size() > 0) {
                    dp[stack.size()] += value;
                } else {
                    dp[0] += value;
                }
                
//                for(int b : dp) {
//                	System.out.print(b + " ");
//                }
//                System.out.println();
            }
        }
        
        

        // 스택이 비어있지 않거나 괄호 쌍이 맞지 않으면 0 출력
        if (!stackcheck || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(dp[0]); // 최종 점수 출력
        }
    }
}
