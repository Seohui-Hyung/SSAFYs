package Main;

//import java.util.Arrays;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 그래프최소비용01_크루스칼 {
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
			// TODO Auto-generated method stub
			return this.W - o.W;
			
//			return Integer.compare(this.W, o.W); // 똑같다
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
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
			
		});
		
		for(int i = 0; i < E; i++) {
			edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		} // 입력 끝
		
		// 크루스칼 제 1장 : 가중치 순으로 정렬을 해라!
		
//		Arrays.sort(edges, new Comparator<Edge>() {
//			
//		});
		
		Arrays.sort(edges);
		
		// 크루스칼 제 2장 : V-1개의 간선을 뽑아라! (사이클이 발생하지 않게)
		// 상호배타집합 (서로소집합, 유니온파인드)
		p = new int[V]; // 0번부터 시작하길래 ㅎ
		
		// make-set을 통해 전체 자신을 대표로 만드는 작업을 수행한다.
		for(int i = 0; i < V; i++) {
//			makeSet(i);
			p[i] = i;
		}
		
		int ans = 0; // 최소 비용을 저장하기 위한 변수
		int pick = 0; // 내가 뽑은 간선의 개수
		
		for(int i = 0; i < E; i++) {
//			int x = edges[i].A;
//			int y = edges[i].B;
//			
//			// 사이클이 발생하는지 검사를 해야한다.
//			if(findSet(x) != findSet(y)) {
//				// 해당 블록에 들어왔다면... 사이클이 아니라는 뜻
//				union(x, y);
//				ans += edges[i].W;
//				pick++;
//			}
			
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
		
//		for(Edge e : edges) {
//			System.out.println(e);
//		}
	} // main
	
	static void makeSet(int x) {
		p[x] = x;
	}
	
	static int findSet(int x) {
//		// 해당 방식이 원래 우리가 알던 코드!
//		if(x == p[x]) return x;
//		return findSet(p[x]);
		
		// 위의 코드가 문제점이 있대... 똑같은 작업을 또 할 수 있어서 효율 down
		// 아래는 패스 컴프레숀을 적용한 코드
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
