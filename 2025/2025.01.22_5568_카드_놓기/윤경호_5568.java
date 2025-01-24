import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int card_num = sc.nextInt();
		int pick_num = sc.nextInt();
		
		String[] card_arr = new String[card_num];
		
		for(int i = 0 ; i < card_num ; i++){
		     card_arr[i] = sc.next();   
		}
		
		//int a = new Integer(card_arr[1]).intValue();
		
		//System.out.print(a + 3);

		int total_num = 1;
		int result = 0;

		for (int i = card_num ; i > card_num - pick_num ; i--) {
			total_num = total_num * i;
		}
		

		int[] get_num = new int[total_num];
        
        for(int i = 0 ; i < card_num ; i++){
            for(int j = 0 ; j < card_num ; j++){
                if(i == j){
                 continue;   
                }
                else{
                String check = card_arr[i] + card_arr[j];
                int a = new Integer(check).intValue();
                
                for(int k = 0 ; k < total_num ; k++){
                    if()
                }
            }
            		}		
		
		
		/*

		int[] card_arr = new int[card_num];

		for (int i = 0 ; i < card_num; i++) {
			card_arr[i] = sc.nextInt();
		}

		int[] set_num = new int[pick_num];

		for (int i = 0 ; i < card_num ; i++) {
            
		}

		for (int i = 0 ; i < 2 ; i++) {
			System.out.print(set_num[i] + " ");
		}
		//System.out.println(total_num);*/
		/*
		for(int i = 0 ; i < card_num ; i++){
		     System.out.print(card_arr[i] + " ");
		}
		*/

		sc.close();

	}

}
