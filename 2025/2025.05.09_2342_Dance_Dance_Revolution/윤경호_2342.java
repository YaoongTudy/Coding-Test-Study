import java.io.*;
import java.util.*;

public class Main {
	
    static int cost(int from, int to) {
        if (from == to) return 1;
        if (from == 0) return 2;
        if (Math.abs(from - to) == 2) return 4;
        return 3;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        int[][][] DP = new int[5][5][100001];


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(DP[i][j], Integer.MAX_VALUE);
            }
        }
        DP[0][0][0] = 0; // 처음

        int cnt = 1;
        while (st.hasMoreTokens()) {
            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                break;
            }


            for (int i = 0; i < 5; i++) {
                for (int ii = 0; ii < 5; ii++) {
                    if (DP[i][ii][cnt - 1] == Integer.MAX_VALUE) continue;

                    // 왼발로
                    if (a != ii) {
                        int newCost = DP[i][ii][cnt - 1] + cost(i, a);
                        DP[a][ii][cnt] = Math.min(DP[a][ii][cnt], newCost);
                    }

                    // 오른발로
                    if (a != i) {
                        int newCost = DP[i][ii][cnt - 1] + cost(ii, a);
                        DP[i][a][cnt] = Math.min(DP[i][a][cnt], newCost);
                    }
                }
            }
            cnt++;
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int ii = 0; ii < 5; ii++) {
                minCost = Math.min(minCost, DP[i][ii][cnt - 1]);
            }
        }

        sb.append(minCost).append("\n");
        System.out.print(sb.toString());
    }
}
