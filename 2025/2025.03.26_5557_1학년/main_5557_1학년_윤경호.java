import java.io.*;
import java.util.*;

public class Main {
    public static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        
        for(int i = 1 ; i < N ; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.parseInt(st.nextToken());
        
        long[][] dp = new long[N][21];
        
        dp[1][arr[1]] = 1;
        
        for(int i = 2 ; i < N  ; i++) {
        	for(int j = 0 ; j <= 20 ; j++) {
        		if(j - arr[i] >= 0) {
            		dp[i][j] = dp[i][j] + dp[i-1][j - arr[i]];
        		}
        		if( j + arr[i] <= 20) {
        			dp[i][j] = dp[i][j] + dp[i-1][j+arr[i]];
        		}

        	}

        	
        }
        
        System.out.println(dp[N - 1][answer]);
        
        
    }

    
}
