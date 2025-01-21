import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int result = 0;
		int hundred;
		int ten;
		int one;
		
		
		for(int i = 1 ; i < T +1 ; i++) {
			if(i >= 1 && i <= 99 ) {
				result++;
			}
			else {
				hundred = i / 100;
				ten = i / 10 - (i / 100 * 10);
				one = i % 10;
				for(int j = -4 ; j <5 ; j++) {
					if((one + j == ten && ten + j == hundred)) {
						result++;
					}
					
				}
			}
			
			
			
		}
		
		System.out.print(result);
		
		sc.close();
		
	}

}

/*

110 안되는거 11개

111 123 135 147 159

210 222 234 257 269

321 333 …

951 963 975 987 999..

i를 -4부터 4까지

*/
