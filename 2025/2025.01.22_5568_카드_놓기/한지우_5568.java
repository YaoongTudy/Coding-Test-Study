import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 한지우_5568 {

	// 카드를 저장할 배열
	static String [] card;
	// 전체 카드 n장, 선택한 카드 k장
	static int n, k;
	// 카드가 선택된 것인지 판별할 visited 배열
	static boolean [] visited;
	// 카드의 중복을 거를 set
	static HashSet<String> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		// 배열 생성
		card = new String[n];
		visited = new boolean[n]; // 초기값 false임
		
		// 카드 저장
		for(int i = 0; i<n; i++) {
			card[i] = br.readLine();
		}
		
		// 카드가 n장 있고 카드를 k장 선택해서 정수를 만드는데
		// 중복있으면 안됨 -> HashSet
		dfs(0, "");
		
		System.out.println(set.size());
	}
	static void dfs(int cnt, String s) {
		// 종료 조건
		if(cnt == k) {
			set.add(s);
			return;
		}else {
			for(int i = 0; i<n; i++) { 
				if(!visited[i]) { // 방문을 하지 않았으면 ㄱㄱ
					visited[i] = true; // 방문으로 변경
					dfs(cnt+1, s+card[i]); 
					visited[i] = false;
				}
			}
		}
	}
}
