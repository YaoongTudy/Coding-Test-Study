import java.util.*;
import java.io.*;

public class Main {
    static String s, t;

    static boolean dfs(String str) { // 거꾸로 생각해보자
        if (str.equals(s)) {
            return true;
        }

        // s의 길이와 같거나 작으면 false 리턴
        if (str.length() <= s.length()) return false;

        boolean flag = false;
        // 문자열 뒤에 A가 있으면 뺀다.
        if (str.endsWith("A")) {
            flag = dfs(str.substring(0, str.length() - 1)); // 마지막거를 빼고 dfs를 돌림

            if (flag) return true;
        }

        // 문자열 맨 앞에 B가 있으면 뒤집고 B를 제거한다.
        if (str.startsWith("B")) {
            // 뒤집는다.
            StringBuilder sb = new StringBuilder(str);

            String temp = sb.reverse().toString();
            flag = dfs(temp.substring(0, str.length() - 1));

            if (flag) return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        t = br.readLine();

        boolean res = dfs(t); // t를 s로 바꾼다

        if (res) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
