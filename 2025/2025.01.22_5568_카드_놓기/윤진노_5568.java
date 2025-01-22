import java.util.HashSet;
import java.util.Scanner;

public class 윤진노_5568 {
    static HashSet<String> set; //같은 순열(다른 카드 조합) 중복 방지
    static int N; // 카드 개수
    static int k; //뽑을 카드 개수
    static String[] arr = new String[11]; // 카드를 스트링으로 둔다
    static boolean[] check; //뽑은 카든지 안뽑은 카든지 체크용

    public static void DFS(String now,int count) {
        if(count == k){ //depth가 k일때
            set.add(now); //set에 기록해둔다.
            return;
        }

        for(int i=0; i<N; i++){
            if(!check[i]) { //만약 안뽑힌 카드라면?
                check[i] = true; //뽑혔다 체크해주고
                DFS(now + arr[i], count + 1); //depth 늘리고, Now에 String qnxdutj
                check[i] = false; //뽑힌거 해제
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        k = sc.nextInt();
        set = new HashSet<>();
        check = new boolean[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.next();
        }
        DFS("",0);
        System.out.println(set.size());
    }
}
