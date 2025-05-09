import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2342 {

    static int getCost(int from, int to) {
        if (from == to) return 1;
        if (from == 0) return 2;
        if (Math.abs(from - to) == 2) return 4;
        return 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sArr = br.readLine().split(" ");
        int[] arr = new int[sArr.length - 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(sArr[i]);
        }

        int N = arr.length;
        int[][] dp = new int[N + 1][25]; // 왼발* 5 + 오른발

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        for (int i = 0; i < N; i++) {
            int now = arr[i]; //밟아야할 발판
            for (int j = 0; j < 25; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;

                int left = j / 5; //왼발 구하기
                int right = j % 5; //오른발구하기

                // 왼발 이동 시
                int nextL = now * 5 + right;
                dp[i + 1][nextL] = Math.min(dp[i + 1][nextL], dp[i][j] + getCost(left, now));

                // 오른발 이동 시
                int nextR = left * 5 + now;
                dp[i + 1][nextR] = Math.min(dp[i + 1][nextR], dp[i][j] + getCost(right, now));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int v : dp[N]) {
            min = Math.min(min, v);
        }

        System.out.println(min);
    }
}
