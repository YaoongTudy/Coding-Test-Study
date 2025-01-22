import java.util.HashSet;
import java.util.Scanner;

public class 윤진노_5568 {
    static HashSet<String> set; //같은 순열(다른 카드 조합) 중복 방지
    static int N; // 카드 개수
    static int k; //뽑을 카드 개수
    static int count=0; //정답
    static String[] arr = new String[11]; // 카드를 스트링으로 둔다
    public static void DFS(String now,int depth,boolean[] check) {
        if(depth == k){ //depth가 k일때
            if (!set.contains(now)){ //만약, 같은 조합이 이미 set에 들어가있지 않으면
                count++; //숫자늘리고
                set.add(now); //set에 기록해둔다.
            }
        }

        for(int i=0; i<N; i++){
            if(!check[i]) { //만약 안뽑힌 카드라면?
                check[i] = true; //뽑혔다 체크해주고
                DFS(now + arr[i], depth + 1, check); //depth 늘리고, Now에 String qnxdutj
                check[i] = false; //뽑힌거 해제
            }

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        k = sc.nextInt();
        set = new HashSet<>();

        for(int i=0; i<N; i++) {
            arr[i] = sc.next();
        }

        boolean[] check = new boolean[N]; //뽑은 카든지 안뽑은 카든지 체크용

        DFS("",0,check);
        System.out.println(count);
    }
}
