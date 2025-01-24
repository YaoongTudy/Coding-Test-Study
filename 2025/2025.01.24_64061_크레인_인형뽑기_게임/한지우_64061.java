import java.util.Stack;

class Solution {
    static Stack<Integer> s = new Stack<>();
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        for(int i = 0; i<moves.length; i++){
            int move = moves[i]-1;

            for(int j = 0; j<board.length; j++){
                if(board[j][move] != 0){
                    int tmp = -1;
                    if(!s.empty()){
                        tmp = s.peek();
                    }

                    s.push(board[j][move]);
                    board[j][move] = 0;

                    if(tmp == s.peek()){
                        s.pop();
                        s.pop();
                        answer += 2;
                    }
                    break;
                }
            }
        }

        return answer;
    }
}
