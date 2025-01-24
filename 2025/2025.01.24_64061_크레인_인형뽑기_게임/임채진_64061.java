import java.util.*;

class Solution {
    Stack<Integer> stack = new Stack<>();
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        
        for (int num : moves) {
            int doll = -1;
            
            for (int i = 0; i < n; i++) {
                if (board[i][num - 1] > 0) { // 인형이 있음
                    doll = board[i][num - 1];
                    board[i][num - 1] = 0;
                    break;
                }   
            }
            
            if (doll != -1) { // 인형이 있음
                if (!stack.isEmpty() && stack.peek() == doll) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(doll);
                }
            }
            
        }
        
        return answer;
    }
}