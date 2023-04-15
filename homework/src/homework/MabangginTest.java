package homework;

import java.io.IOException;
import java.util.Scanner;

public class MabangginTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int square[][];
        int val = 1;
        int n = 0;
        int row = 0;    
        int col = 0;    
       
        System.out.print("홀수 숫자만 입력 (예: 3, 5, 7, 9...) :");
        
        try {
			n = System.in.read()-48;
		} catch (IOException e) {
			e.printStackTrace();
		}
       
        col = n/2;
        square =  new int[n][n];
       
        while(val <= n*n){
                square[row][col] = val;
               
                if(val % n == 0){
                        row++;
                }else{
                        row--;
                        col++;
                }
               
                if(row < 0)
                        row = n-1;
                if(row >= n)
                        row = 0;
                if(col < 0)
                        col = n-1;
                if(col >= n)
                        col = 0;
                val++;
                
        }
       
        for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                        System.out.printf("%3d",square[i][j]);
                }
                System.out.println();
        }
		
	}

}
