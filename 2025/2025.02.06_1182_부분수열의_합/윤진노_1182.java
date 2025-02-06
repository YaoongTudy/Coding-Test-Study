import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182_부분수열의합 {
    static int N,S;
    static int[] arr;
    static int answer = 0;
    public static void DFS(int depth, int count,int num){
        if(depth == N){
            if(count == S && num>0){
                answer ++;
            }
            return;
        }

        DFS(depth+1,count+arr[depth],num+1);
        DFS(depth+1,count,num);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i= 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0,0,0);
        System.out.println(answer);
    }
}
