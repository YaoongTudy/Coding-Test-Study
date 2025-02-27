import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Long> numbers = new ArrayList<>();

        for(int i = 1 ; i <= 10 ; i++) {
        	combi(0, i, new ArrayList<>() , numbers);
        }
        
        Collections.sort(numbers);
        
        if(N < numbers.size()) {
        	System.out.println(numbers.get(N));
        }else {
        	System.out.println(-1);
        }
        
    }

    // 재귀적으로 조합을 생성하는 함수
    private static void combi(int start, int k, List<Integer> current, List<Long> result) {
    	if(k == 0) {
    		StringBuilder sb = new StringBuilder();
    		for(int i = current.size() - 1; i >= 0 ;  i--) {
    			sb.append(current.get(i));
    		}
    		result.add(Long.parseLong(sb.toString()));
    		return;
    	}
        for(int i = start ; i <= 9 ; i++) {
        	current.add(i);
        	combi(i + 1, k - 1, current, result);
        	current.remove(current.size() - 1);
        }
    }

}
