import java.util.*;
import java.io.*;

public class 임채진_2240 {
    static int t;
    static int w;
    static int[] orders;
    static int[][][] dp;
    static int INT_MIN = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        orders = new int[t + 1];
        for (int i = 1; i <= t; i++) {
            orders[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[t + 1][w + 1][3];

        for (int i = 0; i <= t; i++) {
            for (int j = 0; j <= w; j++) {
                Arrays.fill(dp[i][j], INT_MIN);
            }
        }

        // 1초일 때
        if (orders[1] == 1) {
            dp[1][0][1] = 1;
            dp[1][1][2] = 0;
        } else {
            dp[1][0][1] = 0;
            dp[1][1][2] = 1;
        }

        for (int i = 2; i <= t; i++) {
            int target = orders[i];

            for (int j = 0; j <= w; j++) {
                for (int k = 1; k <= 2; k++) {
                    if (dp[i - 1][j][k] != INT_MIN && target == k) { // 움직이지 않고 같을 경우
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k] + 1);
                    }

                    if (dp[i - 1][j][3 - k] != INT_MIN && target == k) { // 움직이지 않고 다를 경우
                        dp[i][j][3 - k] = Math.max(dp[i][j][k], dp[i - 1][j][3 - k]);
                    }

                    if (j > 0 && dp[i - 1][j - 1][3 - k] != INT_MIN && target == k) { // 움직여서 같게 되는 경우
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - 1][3 - k] + 1);
                    }

                    if (j > 0 && dp[i - 1][j - 1][k] != INT_MIN && target == k) { // 움직여서 다르게 되는 경우
                        dp[i][j][3 - k] = Math.max(dp[i][j][3 - k], dp[i - 1][j - 1][k]);
                    }
                }
            }
        }

        int ans = 0;
        for (int j = 0; j <= w; j++) {
            for (int k = 1; k <= 2; k++) {
                ans = Math.max(ans, dp[t][j][k]);
            }
        }

        System.out.println(ans);
    }
}
