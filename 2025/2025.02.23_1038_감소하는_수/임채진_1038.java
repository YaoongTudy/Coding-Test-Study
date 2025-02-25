import java.util.*;
import java.io.*;

public class P1038_감소하는_수 {
    static int n, ans;
    static int[] arr = new int[10];
    static ArrayList<Integer> candidates = new ArrayList<>();
    static ArrayList<String> list = new ArrayList<>();

    static void calculate(int idx, String s) {
        if (list.size() > 1000000) {
            return;
        }

        for (int i = 0; i < 10; i++) {

            if (s.length() == 0 || s.charAt(s.length() - 1) - '0' > i) {
                list.add(new String(s + i));
                calculate(idx + 1, new String(s + i));
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }

        calculate(0, "");

        ArrayList<Long> alist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            alist.add(Long.parseLong(list.get(i)));
        }
        Collections.sort(alist);

        if (alist.size() <= n) {
            System.out.println(-1);
        } else {
            System.out.println(alist.get(n));
        }
    }
}
