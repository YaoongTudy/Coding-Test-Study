import java.io.*;
import java.util.*;

public class Main_5557_1학년_한지우 {

	static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		num = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		// 입력 끝
		
		// 점화식
		// dp[i][j] 
		// i번째 수까지 계산한 결과가 j일때의 경우의 수를 저장 
		long[][] dp = new long[n][21];
		
		// dp[0][num[0]] = 1
		// 첫번째 수까지 계산했을때 결과가 num[0]인게 1가지 
		dp[0][num[0]] = 1;
		
		// 중간에 나오는 수가 모두 0 이상 20 이하
		// 20을 넘는 수는 모른다
		// n-1번째 수가 결과여야함 그래서 범위 밑에처럼 해줌
		for(int i = 1; i<n-1; i++) {
			for(int j = 0; j<=20; j++) {
				if(j - num[i]>=0) dp[i][j] += dp[i-1][j-num[i]];
				if(j + num[i]<=20) dp[i][j] += dp[i-1][j+num[i]];
			}
		}
		
		// n-1이 결과값이니까 n-2번째 수까지 계산한 결과가 num[n-1]인 경우의 수를 출력 
		System.out.println(dp[n-2][num[n-1]]);
	}
}
