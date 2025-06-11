import java.util.*;
import java.io.*;

public class 임채진_23843 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Integer[] list = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list, Collections.reverseOrder());

        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {

            if (pq.size() >= m) {
                time = pq.poll();
            }

            pq.add(time + list[i]);
        }

        while (!pq.isEmpty()) {
            time = pq.poll();
        }

        System.out.println(time);

    }
}
