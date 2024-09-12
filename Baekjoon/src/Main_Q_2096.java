import java.util.Scanner;

public class Main_Q_2096 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] board = new int[N + 1][3];
		
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = sc.nextInt();
            }
        }
 
        int[][] minDp = new int[N + 1][3];
        int[][] maxDp = new int[N + 1][3];
        
        for(int i = 1; i <= N; i++) {
            maxDp[i][0] += Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + board[i][0];
            maxDp[i][1] += Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + board[i][1];
            maxDp[i][2] += Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + board[i][2];
            
            minDp[i][0] += Math.min(minDp[i - 1][0], minDp[i - 1][1]) + board[i][0];
            minDp[i][1] += Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + board[i][1];
            minDp[i][2] += Math.min(minDp[i - 1][1], minDp[i - 1][2]) + board[i][2];
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < 3; i++) {
            min = Math.min(min, minDp[N][i]);
            max = Math.max(max, maxDp[N][i]);
        }
        
        System.out.println(max + " " + min);
	}
}
