import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5557_1학년 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
           arr[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N][21];//N번째까지 뽑았을때, j번째 번호가 몇개있는지
        int start = arr[0];
        dp[0][start] = 1;

        for(int i=1; i<N-1; i++){
            int now = arr[i];
            for(int j=0; j<=20; j++) {
                if (dp[i - 1][j] == 0) continue;
                int nextPlus = j + now;
                if (nextPlus <= 20) {
                    dp[i][nextPlus] += dp[i - 1][j];
                }

                int nextMinus = j - now;
                if (nextMinus >= 0) {
                    dp[i][nextMinus] += dp[i - 1][j];
                }

            }
        }

        int result = arr[N-1];
        System.out.println(dp[N-2][result]);


    }
}
