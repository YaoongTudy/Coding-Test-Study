import java.util.*;
import java.io.*;

class Con implements Comparable<Con> {
    int value;
    @Override
    public int compareTo(Con other) {
        return Integer.compare(this.value, other.value);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tablet = 0;
        int concent = 0;

        st = new StringTokenizer(br.readLine());
        tablet = Integer.parseInt(st.nextToken());
        concent = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] t = new int[tablet];

        for (int i = 0; i < tablet; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(t); // 정렬

        PriorityQueue<Con> que = new PriorityQueue<>();
        for (int i = tablet - 1; i >= 0; i--) {
            if (que.size() < concent) {
                Con con = new Con();
                con.value = t[i];
                que.offer(con);
            } else {
                Con con = que.poll();
                con.value += t[i];
                que.offer(con);
            }
        }

        int answer = 0;
        for (Con con : que) {
            answer = Math.max(answer, con.value);
        }

        System.out.println(answer);
    }
}
