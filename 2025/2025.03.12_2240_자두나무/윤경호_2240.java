import java.util.*;
import java.io.*;

public class Main {
    public static int T, W;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        int[][] arr = new int[2][T + 1];

        for (int i = 1; i <= T; i++) {
            int a = Integer.parseInt(br.readLine()) - 1;
            arr[a][i] = 1;
        }

        int[][][] dp = new int[2][T + 1][W + 1];
        // 모든 값을 매우 작은 값으로 초기화
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= T; j++) {
                for (int m = 0; m <= W; m++) {
                    dp[i][j][m] = -1000000000; // 불가능한 상태를 나타냄
                }
            }
        }
        dp[0][0][0] = 0; // 초기 상태: 나무 0, 시간 0, 이동 0번

        // DP 계산
        for (int j = 1; j <= T; j++) {
            for (int m = 0; m <= W; m++) {
                for (int i = 0; i < 2; i++) {
                    // 머무는 경우
                    if (dp[i][j - 1][m] != -1000000000) {
                        dp[i][j][m] = dp[i][j - 1][m] + arr[i][j];
                    }
                    // 이동하는 경우
                    if (m >= 1 && dp[1 - i][j - 1][m - 1] != -1000000000) {
                        dp[i][j][m] = Math.max(dp[i][j][m], dp[1 - i][j - 1][m - 1] + arr[i][j]);
                    }
                }
            }
        }

        // 최대값 찾기
        int ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int m = 0; m <= W; m++) {
                ans = Math.max(ans, dp[i][T][m]);
            }
        }
        System.out.println(ans);
    }
}
