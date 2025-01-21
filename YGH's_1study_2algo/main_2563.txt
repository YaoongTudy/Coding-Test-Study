import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		
		int[][] dohwaji = new int[101][101];
		int result = 0;
		
		for(int i = 0 ; i < 101 ; i++) {
			for(int j = 0 ; j < 101 ; j++) {
				dohwaji[i][j] = 0;
			}
		}
		
		int colorpaper_x = 0;
		int colorpaper_y = 0;
		
		for(int i = 0 ; i < T ; i++) {
			colorpaper_x = sc.nextInt();
			colorpaper_y = sc.nextInt();
			
			for(int j = 0 ; j < 10 ; j++) {
				for(int k = 0 ; k < 10 ; k++) {
				dohwaji[colorpaper_x + k][colorpaper_y+j] = 1;
				dohwaji[colorpaper_x+j][colorpaper_y+k] = 1;
				}
			}
			
		}
		
		for(int i = 0 ; i < 101 ; i++) {
			for(int j = 0 ; j < 101 ; j++) {
				if(dohwaji[i][j] == 1) {
					result++;
				}
			}
		}
		
		System.out.print(result);
		
		
		sc.close();
	}

}
