import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Q_3184 {
	static int R, C;
	static int sheep, fox;
	static char[][] map;
	static boolean[][] visited;
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j] == 'v') fox++;
				else if(map[i][j] == 'o') sheep++;
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] != '#' && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(sheep + " " + fox);
	}

	private static void bfs(int x, int y) {
		 Queue<int[]> q = new LinkedList<>();
		 q.add(new int[] {x, y});
		 visited[x][y] = true;
		 
		 int yang = 0; // 영역 내 양
		 int yeowoo = 0; // 영역 내 여우
		 
		 while(!q.isEmpty()) {
			 int[] now = q.poll();
			 x = now[0];
			 y = now[1];
			 
			 if(map[x][y] == 'o') yang++;
			 else if(map[x][y] == 'v') yeowoo++;
			 
			 for(int d = 0; d < 4; d++) {
				 int nx = x + dx[d];
				 int ny = y + dy[d];
				 
				 if(nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny]) continue;
				 if(map[nx][ny] != '#') {
					 q.add(new int[] {nx, ny});
					 visited[nx][ny] = true;
				 }
			 }
		 }
		 
		 if(yang > yeowoo) fox -= yeowoo; // 양 승
		 else sheep -= yang; // 늑대 승
	}
}
