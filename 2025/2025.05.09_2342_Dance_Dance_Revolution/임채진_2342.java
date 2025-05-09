import java.util.*;
import java.io.*;

public class Main {
    static int MAX_N = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][][] dp = new int[MAX_N][5][5];

        // 초기화
        for (int i = 0; i < MAX_N; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        // 초기 조건
        dp[0][0][0] = 0;

        st = new StringTokenizer(br.readLine());
        int index = 1;
        while (true) {
            int input = Integer.parseInt(st.nextToken());

            if (input == 0) break; // 종료 조건

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (dp[index - 1][i][j] != Integer.MAX_VALUE) { // i가 왼쪽, j가 오른쪽

                        // 왼쪽
                        boolean flag = false;
                        if (input != j) { // 왼쪽과 오른쪽 발이 결과적으로 같으면 안됨
                            if (i == input) { // 같은 위치
                                flag = true;
                                dp[index][input][j] = Math.min(dp[index - 1][i][j] + 1, dp[index][input][j]);
                            } else if (i == 0) { // 그 전에 중앙에 있었음
                                dp[index][input][j] = Math.min(dp[index - 1][i][j] + 2, dp[index][input][j]);
                            } else if ((i  == 2 && input == 4) || (i  == 4 && input == 2) || (i  == 1 && input == 3) || (i  == 3 && input == 1)) { // 반대편에 있음
                                dp[index][input][j] = Math.min(dp[index - 1][i][j] + 4, dp[index][input][j]);
                            } else { // 인접
                                dp[index][input][j] = Math.min(dp[index - 1][i][j] + 3, dp[index][input][j]);
                            }
                        }

                        // 오른쪽
                        if (!flag && input != i) { // 왼쪽과 오른쪽 발이 결과적으로 같으면 안됨
                            if (j == input) { // 같은 위치
                                dp[index][i][input] = Math.min(dp[index - 1][i][j] + 1, dp[index][i][input]);
                            } else if (j == 0) { // 그 전에 중앙에 있었음
                                dp[index][i][input] = Math.min(dp[index - 1][i][j] + 2, dp[index][i][input]);
                            } else if ((j  == 2 && input == 4) || (j  == 4 && input == 2) || (j  == 1 && input == 3) || (j  == 3 && input == 1)) { // 반대편에 있음
                                dp[index][i][input] = Math.min(dp[index - 1][i][j] + 4, dp[index][i][input]);
                            } else { // 인접
                                dp[index][i][input] = Math.min(dp[index - 1][i][j] + 3, dp[index][i][input]);
                            }
                        }

                    }
                }
            }

            index++;
        }

        /*for (int k = 1; k < index; k++) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Arrays.toString(dp[k][i]));
            }
            System.out.println();
        }*/

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ans = Math.min(ans, dp[index - 1][i][j]);
            }
        }

        System.out.println(ans);

    }
}
