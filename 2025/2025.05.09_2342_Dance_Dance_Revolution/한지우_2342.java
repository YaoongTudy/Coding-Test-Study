import java.io.*;
import java.util.*;

public class 한지우_2342 {
	// 1 2 2 4 0
    
    // 중앙에서 움직일땐 2
    // 인접지점 이동할땐 3
    // 지점 반대방향으로 이동할땐 4
	
	/*
	 *	   중앙 위 왼쪽 아래 오른쪽
	 * 중앙 1	  2	 2	2 	2
	 * 위  0	  1  3  4   3
	 * 왼쪽 0  3  1	3   4 
	 * 아래 0  4  3  1   3 
	 * 오른쪽 0 3  4  3  1
	 */
	
	static int[][] him = {
			{1, 2, 2, 2, 2},
			{0, 1, 3, 4, 3},
			{0, 3, 1, 3, 4},
			{0, 4, 3, 1, 3},
			{0, 3, 4, 3, 1}
	};
	
	static ArrayList<Integer> list;
	static int[][][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        list = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        
        int tmp = Integer.parseInt(st.nextToken());
        
        while(tmp != 0) {
        	list.add(tmp);
        	tmp = Integer.parseInt(st.nextToken());
        }
        
//        System.out.println(list);
        
        // dp[현재 발판 순서][왼발 발판 위치][오른발 발판 위치]
        
        dp = new int[list.size()][5][5];
        
        int result = dance(0, 0, 0);
        
        
//        System.out.println(Arrays.deepToString(dp));
        
//        for(int[][] i: dp) {
//        	for(int[] j: i) {
//        		System.out.println(Arrays.toString(j));
//        	}
//        	System.out.println();
//        }
        
        System.out.println(dp[0][0][0]);
	}

	// dp[현재 발판 순서][왼발 발판 위치][오른발 발판 위치]
	private static int dance(int num, int left, int right) {
		
		if(num == list.size()) return 0;
		
		if(dp[num][left][right] != 0) {
			return dp[num][left][right];
		}
		
		int next = list.get(num);
		
		dp[num][left][right] = Math.min(dance(num+1, next, right)+him[left][next],
										dance(num+1, left, next)+him[right][next]);
		
		
		return dp[num][left][right];
	}
}
