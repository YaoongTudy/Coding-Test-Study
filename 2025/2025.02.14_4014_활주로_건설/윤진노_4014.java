import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
/*
 
1.N * N 의 배열을 순차적으로 돌면서
cnt =0으로 시작하며 높이가 안변했는지 체크 && 변했다면 1만큼 올라간건지 체크 && cnt가 X 이상인지를 체크
다 올바르다면 answer ++
*/
/**
 
 찾은 반례 :
 올라가는거 체크할때 내려가면 다시 cnt 초기화해줘야함
 @author SSAFY
 *
 */
public class Solution {  static int[][] arr;
    static int N,X,answer;
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
 
        int T = Integer.parseInt(st.nextToken());
 
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
 
            answer = 0;
            arr = new int[N][N];
 
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            /*가로 부터 보기*/
            for(int i=0; i<N; i++) {
                int[] tem = arr[i];
                if(check1(tem)) answer++;
            }
 
            //세로 보기
            for(int i=0; i<N; i++) {
                int[] tem = new int[N];
                for(int j=0; j<N; j++) {
                    tem[j] = arr[j][i];
                }
 
                if (check1(tem)) answer++;
 
 
            }
 
            System.out.printf("#%d %d",t,answer);
            System.out.println();
        }
    }
 
    private static boolean check1(int[] tem) {
        int cnt = X-1;
        int now = tem[0];
        for(int j=1; j<N; j++) {
            //이전칸과 높이가 같을 때
            if(now == tem[j]) {
                cnt -= 1;
                //이전칸보다 높이가 한칸 높을때
            }else if(tem[j] == now +1) {
                if(cnt <= 0) {
                    now = tem[j];
                    cnt = X-1;
 
                }else {
                    //이 줄은 죽은 줄
                    return false;
                }
            }else if(tem[j] == now -1) { //이전보다 한칸이 낮을때
                for(int k=0; k<X; k++){
                    if(k+j >= N) return false;
                    if(tem[k+j] != now-1) return false;
                }
                j = j+X-1;
                now =  now-1;
                cnt = X;
            }else { //2칸이상 차이날 때
                return false;
            }
        }
 
        return true;
    }
 
 
}
