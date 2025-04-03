import java.util.*;
import java.io.*;

public class 임채진_21758 {
    static int n;
    static int[] arr;
    static long ans;
    static ArrayList<Integer> candidates = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] prefixSum = new long[n + 1];
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += arr[i];
            prefixSum[i] = sum;
        }

        // 벌1 맨 왼쪽, 벌통 맨 오른쪽
        for (int i = 2; i < n; i++) { // 벌2의 위치 정함
            ans = Math.max(ans, prefixSum[n] - prefixSum[1] + prefixSum[n] - prefixSum[i] - arr[i]);
        }

        // 벌통 맨 왼쪽, 벌 1 맨 오른쪽
        for (int i = 2; i < n; i++) { // 벌2의 위치 정함
            ans = Math.max(ans, prefixSum[n - 1] - prefixSum[0] + prefixSum[i - 1] - prefixSum[0] - arr[i]);
        }

        // 벌1 왼쪽, 벌2 오른쪽
        for (int i = 2; i < n; i++) { // 벌통 위치 정함
            ans = Math.max(ans, prefixSum[i] - prefixSum[1] + prefixSum[n - 1] - prefixSum[i - 1]);
        }

        System.out.println(ans);
    }

}