import java.util.*;

class Solution {
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int check = -1;
        
        Stack<Integer> stackInt = new Stack<>();
        
        for(int i = 0 ; i <=moves.length-1; i++){
            for(int j = 0 ; j <=board.length-1; j++){
                   if(board[j][moves[i]-1] != 0){
                       stackInt.push(board[j][moves[i]-1]);
                       board[j][moves[i]-1] = 0;
                       break;
                   }
            }
                if(stackInt.empty()){
                    
                }
                else if(check == stackInt.peek()){
                stackInt.pop();
                stackInt.pop();
                answer = answer + 2;

                 if(stackInt.size() == 0)
                 {check = -1;}
                 else{
                 check = stackInt.peek();
                 }
             }
                else{
                    check = stackInt.peek();
                }
        }

        return answer;
    }
    
    
}
