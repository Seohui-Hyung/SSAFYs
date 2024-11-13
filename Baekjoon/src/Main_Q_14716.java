import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Q_14716 {
	static int M, N;
	static int[][] banner;
	static boolean[][] visited;
	static int cnt = 0;
	
	static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		banner = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				banner[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] && banner[i][j] == 1) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int d = 0; d < 8; d++) {
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];
				
				if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
				if(!visited[nx][ny] && banner[nx][ny] == 1) {
					visited[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
		}
	}

}
