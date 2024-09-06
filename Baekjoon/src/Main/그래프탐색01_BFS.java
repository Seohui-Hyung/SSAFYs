package Main;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 그래프탐색01_BFS {
	static int V, E; // 정점의 갯수, 간선의 갯수
	static List<Integer>[] adj; // 인접리스트, 리스트 안에 리스트도 가능
	static boolean[] visited; // 방문쳌
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adj = new ArrayList[V + 1]; // 배열만 만든 거고 안에 리스트를 생성하지는 X
		for(int i = 1; i <= V; i++) // 1번 정점부터 시작을 하니까
			adj[i] = new ArrayList<>();
		
		visited = new boolean[V + 1];
		
		for (int i = 0 ; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adj[A].add(B);
			adj[B].add(A); // 무향이니까
			
		} // 간선 입력 완료
		
		bfs(1);
		
	}//main
	
	// v : 시작 정점
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v); // 시작 정점을 큐에 넣는다.
		visited[v] = true; // 시작 정점을 방문쳌
		
		// 큐가 공백 상태가 될 때까지 돌겠다.
		// 큐가 공백 상태가 아니면 돌겠다.
		while(!q.isEmpty()) {
			int curr = q.poll(); // 정점 하나를 꺼낼거야
			System.out.println(curr);
			
			// curr 인접하면서 방문하지 않은 친구들을 방문할거야
			for(int w : adj[curr]) {
				if(!visited[w]) {
					q.add(w);
					visited[w] = true;
				}
			}
			
//			위와 같음
//			for(int i = 0; i < adj[curr].size(); i++) {
//				int w = adj[curr].get(i);
//			}
		}
	}
	
	static String input = "7 9\r\n"
			+ "1 2\r\n"
			+ "1 3\r\n"
			+ "1 6\r\n"
			+ "2 4\r\n"
			+ "2 7\r\n"
			+ "3 4\r\n"
			+ "4 7\r\n"
			+ "5 6\r\n"
			+ "5 7";

}
