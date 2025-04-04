import java.io.*;
import java.util.*;

public class Main {
	public static int N, bee1, bee2, honeyhouse, small, small_x, small_x2;
	public static int[] arr, arr2, arr3;
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		arr2 = new int[N];
		arr3 = new int[N];
		st = new StringTokenizer(br.readLine());
		small = Integer.MAX_VALUE;
		small_x2 = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				arr[i] = Integer.parseInt(st.nextToken());
				arr2[i] = arr[i];
			} else {
				arr[i] = Integer.parseInt(st.nextToken());
				arr2[i] = arr2[i - 1] + arr[i];
			}

		}
		for(int i = N-1 ; i >= 0 ; i--) {
			if(i == N-1) {
				arr3[i] = arr[i];
				
			}else {
				arr3[i] = arr3[i+1] + arr[i];
			}
			
			
			
		}
		


		for (int i = 0; i < N; i++) {
			whatthefuck2(i);
		}
		System.out.println(answer);

	}

	public static void whatthefuck2(int home) {
		int localanswer = 0;
		if (home == N - 1) {
			bee1 = 0;

			for (int i = 1; i < N - 1; i++) {
				localanswer = 0;

				localanswer = arr2[N - 1] * 2 - arr2[i] - arr[bee1] - arr[i];

				answer = Math.max(localanswer, answer);
			}
		} else if (home == 0) {
			bee1 = N - 1;

			for (int i = N - 2; i > 0; i--) {
				localanswer = 0;

				localanswer = arr3[0] * 2 - arr3[i] - arr[bee1] - arr[i];

				answer = Math.max(localanswer, answer);
			}
		} else {
			bee1 = 0;
			bee2 = N - 1;
			localanswer = 0;

			localanswer = arr3[0] + arr[home] - arr[bee1] - arr[bee2];

			answer = Math.max(localanswer, answer);

		}

	}

}
