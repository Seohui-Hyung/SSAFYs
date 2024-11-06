import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_Q_4386 {
	
	static boolean[] visit;
	static PriorityQueue<Price> pq;
	static int n;
	static Node[] star; // 별의 좌표 저장
	static double ans = 0.0d; // 최소 비용의 합을 저장하는 변수
	
	// 별의 좌표 나타내는 클래스
	static class Node {
		double x;
		double y;
		
		public Node(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	// 현재 별과 비용을 나타내는 클래스
	static class Price implements Comparable<Price> {
		int now; // 현재 별의 인덱스
		double cost; // 현재 별까지의 비용 (거리)
		
		public Price(int now, double cost) {
			this.now = now;
			this.cost = cost;
		}
		
		// cost 기준으로 오름차순 정렬
		public int compareTo(Price p) {
			return Double.compare(this.cost, p.cost); 
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		star = new Node[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			double nx = Double.parseDouble(st.nextToken());
			double ny = Double.parseDouble(st.nextToken());
			
			star[i] = new Node(nx, ny);
		}
		
		constell();
		System.out.println(ans);
	}

	// 프림 알고리즘 사용
	private static void constell() {
		visit = new boolean[n];
		pq = new PriorityQueue<>();
		pq.add(new Price(0, 0.0d)); // 시작 별 우선순위 큐에 추가
		
		while(!pq.isEmpty()) {
			Price p = pq.poll(); // 비용이 가장 적은 간선 꺼내기
			
			if(visit[p.now]) continue; // 방문했으면 넘어가기
			visit[p.now] = true; // 현재 방문 별
			
			ans += p.cost; // 비용 추가
			
			// 현재 별과 연결되지 않은 다른 별들과의 거리 계산
			for(int i = 0; i < n; i++) {
				if(!visit[i]) {
					double dist = Math.sqrt(Math.pow(Math.abs(star[p.now].x - star[i].x), 2) + Math.pow(Math.abs(star[p.now].y - star[i].y), 2));
					double round = Math.round(dist * 100.0) / 100.0; // 거리값 소수점 아래 둘째 자리에서 반올림
					pq.add(new Price(i, round)); // 거리와 함께 새 별을 우선순위 큐에 추가
				}
			}
		}
		
	}
}
