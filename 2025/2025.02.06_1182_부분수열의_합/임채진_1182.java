import java.util.*;
import java.io.*;

public class P1182_부분수열의_합_비트마스킹 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int snum = 1 << n;
        int ans = 0;
        for (int i = 1; i < snum; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) > 0) {
                    sum += arr[j];
                }
            }

            if (s == sum) {
                ans += 1;
            }
        }

        System.out.println(ans);
    }
}
