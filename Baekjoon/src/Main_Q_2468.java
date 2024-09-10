import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Q_2468 {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		int highest = 0;
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				highest = Math.max(highest, map[r][c]);
			}
		} // 입력
		
		int max = 0;
		
		for(int rain = 0; rain < highest; rain++) {
			int cnt = 0;
			visit = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j ++) {
					if(!visit[i][j] && map[i][j] > rain)
						cnt += dfs(i, j, rain);
				}
			}
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
	}

	private static int dfs(int r, int c, int depth) {
		
		visit[r][c] = true;
		
		for(int n = 0; n < 4; n++) {
			
			int nr = r + dr[n];
			int nc = c + dc[n];			
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(visit[nr][nc]) continue;
			if(map[nr][nc] > depth) {
				dfs(nr, nc, depth);
			}
		}
		
		return 1;
	}
	
}
