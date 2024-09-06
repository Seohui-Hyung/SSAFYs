package Main;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 그래프최소비용01_크루스칼2 {
	static class Edge implements Comparable<Edge>{
		int A, B, W;

		public Edge(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.W - o.W;
		}
		
	}
	
	static int[] p; // 대표자를 저장할 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); // 정점의 개수 (정점의 시작번호를 보고)
		int E = sc.nextInt(); // 간선의 개수
		
		Edge[] edges = new Edge[E];
		
		int[][] edges2 = new int[E][3]; // [0] : 시작, [1] : 도착, [2] : 가중치
		
		Arrays.sort(edges2, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
			
		});
		
		for(int i = 0; i < E; i++) {
			edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		} // 입력 끝

		Arrays.sort(edges);

		p = new int[V]; // 0번부터 시작하길래 ㅎ
		
		// make-set을 통해 전체 자신을 대표로 만드는 작업을 수행한다.
		for(int i = 0; i < V; i++) {
			p[i] = i;
		}
		
		int ans = 0; // 최소 비용을 저장하기 위한 변수
		int pick = 0; // 내가 뽑은 간선의 개수
		
		for(int i = 0; i < E; i++) {
			
			int px = findSet(edges[i].A);
			int py = findSet(edges[i].B);
			
			if(px != py) {
				union(px, py);
				ans += edges[i].W;
				pick++;
			}
			
			if(pick == (V - 1)) break;
			
		} // 간선의 총 개수만큼 돌면서...
		
		System.out.println(ans);

	} // main
	
	static void makeSet(int x) {
		p[x] = x;
	}
	
	static int findSet(int x) {
		// 패스 컴프레숀
		if(x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		// x와 y가 대표자여야만 한다.
		p[findSet(y)] = findSet(x);
	}
	
	static String input= "7 11\r\n"
			+ "0 1 32\r\n"
			+ "0 2 31\r\n"
			+ "0 5 60\r\n"
			+ "0 6 51\r\n"
			+ "1 2 21\r\n"
			+ "2 4 46\r\n"
			+ "2 6 25\r\n"
			+ "3 4 34\r\n"
			+ "3 5 18\r\n"
			+ "4 5 40\r\n"
			+ "4 6 51";
}
