package Main;
import java.util.Scanner;

public class 그래프탐색01_DFS {
	static int V, E;
	static int[][] adj;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adj = new int[V + 1][V + 1];
		visited = new boolean[V + 1];
		
		for (int i = 0 ; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adj[A][B] = adj[B][A] = 1; // 무향이니까
		} // 간선 입력 완료
		
		dfs(1);
		
	}//main
	
	// v : 현재 내가 있는 정점
	static void dfs(int v) {
		visited[v] = true;
		System.out.println(v);
		
		// 나와 인접하면서 방문하지 않은 정점을 방문하겠다.
		for (int i = 1; i <= V; i++) {
			if(!visited[i] && adj[v][i] == 1) {
				dfs(i); // 방문하지 않았으면 해당 정점으로 내려보내겠다.
			}
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
