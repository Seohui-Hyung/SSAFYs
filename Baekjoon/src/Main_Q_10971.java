import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Q_10971 {
	static int N;
	static int[][] W;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		W = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[1] = true; // 시작 지점 방문 처리
		ans = Integer.MAX_VALUE;
		trip(1, 1, 1, 0);
		System.out.println(ans);
	}
	
	// 여행 함수 : 시작 위치 1 / 현 위치 1 / 방문지 개수 1 / 비용 0
	private static void trip(int start, int now, int cnt, int cost) {
		if(W[now][start] != 0 && cnt == N) {
			ans = Math.min(ans, cost + W[now][start]);
			return;
		}
		
		// 다음 목적지 순회
		for(int i = 1; i <= N; i++) {
			// 경로가 존재하고 방문 전이면 이동
			if(W[now][i] > 0 && visited[i] == false) {
				visited[i] = true;
				trip(start, i, cnt + 1, cost + W[now][i]); // 다음 여행
				visited[i] = false;
			}
		}
	}
	
}
