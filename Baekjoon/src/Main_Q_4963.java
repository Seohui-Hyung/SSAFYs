import java.util.Scanner;

// DFS
public class Main_Q_4963 {
	static int[][] board;
	static int w, h;
	static int ans;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			h = sc.nextInt();
			w = sc.nextInt();
			
			if (w == 0 && h == 0)
				break;
			
			board = new int[w][h];
			ans = 0;
			
			for (int r = 0; r < w; r++) {
				for (int c = 0; c < h; c++) {
					board[r][c] = sc.nextInt();
				}
			}
			
			map();
			
			System.out.println(ans);
		}
	}
	
	static void map() {
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				if (board[i][j] == 1) {
					board[i][j] = 0;
					ans++;
					dfs(i, j);
				}
			}
		}
	}
	
	static void dfs(int x, int y) {
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < w && ny >= 0 && ny < h && board[nx][ny] == 1) {
				board[nx][ny] = 0;
				dfs(nx, ny);
			}
		}
	}
}
