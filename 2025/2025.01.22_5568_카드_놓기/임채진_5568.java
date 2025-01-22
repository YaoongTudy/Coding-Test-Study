import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer> candidates = new ArrayList<>();
    static Set<String> set = new HashSet<>();

    static void calculate(int idx) {
        if (idx == k) { // 종료 조건
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(candidates.get(i));
            }

            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                candidates.add(arr[i]);

                calculate(idx + 1);

                candidates.remove(candidates.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        calculate(0);

        System.out.println(set.size());
    }
}
