import java.util.*;

public class Main {

	public static int[] arr1;
	public static int answer = 0;
	public static int S;
	public static boolean[] pick;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		S = sc.nextInt();
		
		arr1 = new int[N];
		pick = new boolean[N];
		
		for(int i = 0 ; i < N ; i++) {
			arr1[i] = sc.nextInt();
		}
		
		ArrayList<Integer> arr3 = new ArrayList<>();
		
		int[] arr2 = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			dps(arr3, 0, i + 1);
			
		}
		
//		dps(arr3, 0, 1);
//		for(int i = 0 ; i < N ; i++) {
//			pick[i] = false;
//		}
//		dps(arr3, 0, 2);
//		for(int i = 0 ; i < N ; i++) {
//			pick[i] = false;
//		}
//		dps(arr3, 0, 3);
//		for(int i = 0 ; i < N ; i++) {
//			pick[i] = false;
//		}
//		dps(arr3, 0, 4);
//		for(int i = 0 ; i < N ; i++) {
//			pick[i] = false;
//		}
//		dps(arr3, 0, 5);
		
		System.out.print(answer);
		
    }
	//dpt2현재 쌓인 상태
	//dpt는 그만큼 뽑을때 탈출하겠다
	public static void dps(ArrayList<Integer> arr, int dpt2 ,int dpt) {
		
		if(arr.size() == dpt) {
//			for(int i = 0 ; i < arr.size() ; i++) {
//				System.out.print(arr.get(i) + " ");
//			}
//			System.out.println();
			int total = 0;
			for(int i = 0 ; i < arr.size() ; i++) {
				total = total + (int)arr.get(i);
			}
			if(total == S) {
				answer++;
			}
			
			return;

		}
		for(int i = dpt2 ; i < arr1.length ; i++ ) {
			if(!pick[i]) {
				pick[i] = true;
				arr.add(arr1[i]);
				dps(arr ,i + 1 ,dpt);
				pick[i] = false;
				arr.remove(arr.size()-1);
				
			}
		}
		
	}
	
	
}
