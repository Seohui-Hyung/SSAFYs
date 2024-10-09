import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_Q_5972 {
	static class Node implements Comparable<Node>{
		int n, cost;
	
		public Node(int n, int cost) {
			this.n = n; // 마을 번호
			this.cost = cost; // 여물비
		}
		
		// 우선순위 큐에서 노드 비교할 때 쓰려고 만듦
		@Override
		public int compareTo(Node o) { // 비용 기준으로 오름차순 정렬
			return this.cost - o.cost;
		}
	}
	
	static int N, M; // N : 마을 수, M : 길 수
	static List<Node>[] map; // 경로와 가중치 저장
	static int[] feed; // 마을까지의 최소 여비 저장
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			map[i] = new ArrayList<>();
		}
		
		feed = new int[N];
		Arrays.fill(feed, 987654321); // 모든 마을까지의 최소 여물 초기화
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1; // 인덱스 0부터
			int b = Integer.parseInt(st.nextToken()) - 1; // 인덱스 0부터
			int c = Integer.parseInt(st.nextToken());
			
			map[a].add(new Node(b, c));
			map[b].add(new Node(a, c)); // 양방향 연결
		}
		
		dijkstra(0);
		System.out.println(feed[N - 1]);
	}

	// 1번 마을부터 N번 마을까지 최소 여물비 계산
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0)); // 시작은 0
		feed[start] = 0; // 출발점에서 자기까지 0
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll(); // 여물비가 가장 적은 노드 꺼내기
			
			// 이미 더 작은 유지비로 방문한 적이 있으면 스킵
			if(feed[curr.n] < curr.cost) continue;
			
			// 해당 마을과 연결된 모든 마을 확인
			for (Node next : map[curr.n]) {
				// 더 작은 비용으로 연결될 수 있으면 업데이트
				if (feed[next.n] > curr.cost + next.cost) {
					feed[next.n] = curr.cost + next.cost;
					pq.add(new Node(next.n, feed[next.n])); // 갱신된 마을 정보를 큐에 추가
				}
			}
		}
		
	}
}
