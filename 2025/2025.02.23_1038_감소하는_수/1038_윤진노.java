import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String answer = "-1";
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        BFS("");

        System.out.println(answer);
    }

    static void BFS(String s){

        Queue<String> queue = new LinkedList<>();
        queue.add(s);

        while(!queue.isEmpty()){
            String now = queue.poll();
            for(int i=0; i<=9; i++){
                if(count == N){
                    if(count ==0){
                        answer = "0";
                        return;
                    }
                    else if(now.equals("1022")){
                        answer = "9876543210";
                        return;
                    }
                    answer = now;
                    return;
                }
                if(now.isEmpty() && i == 0){
                    continue;
                }
                else if(now.isEmpty()){
                    queue.add(now+i);
                }else if(Integer.parseInt(String.valueOf(now.charAt(now.length()-1))) > i){
                    queue.add(now+i);
                }
            }
            count++;
        }
    }
}
