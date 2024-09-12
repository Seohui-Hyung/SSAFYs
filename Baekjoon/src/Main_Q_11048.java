import java.util.Scanner;

public class Main_Q_11048 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] maze = new int[N + 1][M + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				maze[i][j] = sc.nextInt();
			}
		}
		
		int[][] arr = new int[N + 1][M + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				arr[i][j] = Math.max(maze[i][j] + arr[i][j - 1], maze[i][j] + arr[i - 1][j]);
			}
		}
		
		System.out.println(arr[N][M]);
	}
}
