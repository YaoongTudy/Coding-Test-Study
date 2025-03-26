import java.io.*;
import java.util.*;

public class P5557_1학년 {
    static int n;
    static int[] arr = new int[101];
    static long[][] dp = new long[101][21];

    static long calc(int sum, int index) {
        if (sum < 0 || sum > 20) return 0;
        if (dp[index][sum] != Integer.MIN_VALUE) return dp[index][sum];
        if (index == n - 1) {
            if (sum == arr[index]) dp[index][sum] = 1;
            else dp[index][sum] = 0;
            return dp[index][sum];
        }

        long count = 0;
        count += calc(sum - arr[index], index + 1);
        count += calc(sum + arr[index], index + 1);
        dp[index][sum] = count;
        return dp[index][sum];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        System.out.println(calc(arr[0], 1));
    }
}