package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_보급로 {
	
	static class Edge implements Comparable<Edge> {

		int x, y, cost;
		
		public Edge(int a, int b, int cost) {
			super();
			this.x = a;
			this.y = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
		
	}
	
	static int[][] road;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			road = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				String str = br.readLine();
				for (int c = 0; c < N; c++) {
					road[r][c] = str.charAt(c) - '0';
				}
			}
			
			int ans = dijkstra(road, N);
			
			System.out.println("#" + test_case + " " + ans);
		}
		
	}
	
	static int dijkstra(int[][] arr, int N) {
		// 배열 무한대로 초기화
		int[][] dist = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		// 지작점 비용 0
		dist[0][0] = 0;
		
		// 우선순위 큐 (비용이 작은 순으로 정렬)
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0, 0, 0));
		
		while(!pq.isEmpty()) {
			Edge current = pq.poll();
			int x = current.x;
			int y = current.y;
			int cost = current.cost;
			
			// 현재 저장된 비용보다 지금 비용이 크면 패스
			if(cost > dist[x][y])
				continue;
			
			// 사방 탐색
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				// 벗어나지 않는 범위에서 탐색
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					int newCost = cost + road[nx][ny];
					
					if (newCost < dist[nx][ny]) {
						dist[nx][ny] = newCost;
						pq.offer(new Edge(nx, ny, newCost));
					}
					
				}
			}
			
		}
		
		// 도착점의 최소 복구 시간 반환
		return dist[N - 1][N - 1];
	}
	
}
