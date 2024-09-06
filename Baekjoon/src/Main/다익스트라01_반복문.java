package Main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 다익스트라01_반복문 {
	static class Node {
		int V, W;
		
		public Node(int v, int w) {
			V = v;
			W = w;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Node>[] adjList; // 인접리스트
	static int[] dist; // 거리배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adjList = new ArrayList[V];
		for(int i = 0; i < V; i++)
			adjList[i] = new ArrayList<>();
			
		dist = new int[V];
		Arrays.fill(dist, INF);
		
		for(int j = 0; j < E; j++) {
//			int A = sc.nextInt();
//			int B = sc.nextInt();
//			int W = sc.nextInt();
//			adjList[A].add(new Node(B, W));
			
			adjList[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		} // 입력완료
		
		dijkstra(0);
		
		System.out.println(Arrays.toString(dist));
			
		}
	
	
	private static void dijkstra(int st) {
		boolean[] visited = new boolean[V];
		
		dist[st] = 0; // 시작 노드까지의 거리는 0으로 초기화
		
		// 어디까지 할지는 문제를 보고 결정! (도착지가 주어졌다면 거기 방문하는 순간 멈추게)
		for(int i = 0; i < V - 1; i++) {
			int min = INF;
			int idx = -1;
			
			for(int j = 0; j < V; j++) {
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}
			
			visited[idx] = true; // 해당 지점 뽑았어! (뽑의 의미)
			
			for(Node node : adjList[idx]) {
				if(!visited[node.V] && dist[node.V] > dist[idx] + node.W) {
					dist[node.V] = dist[idx] + node.W;
				}
			}
		}
	}


	static String input= "6 11\r\n" + "0 1 4\r\n" + "0 2 2\r\n"
			+ "0 5 25\r\n" + "1 3 8\r\n" + "1 4 7\r\n"
			+ "2 1 1\r\n" + "2 4 4\r\n" + "3 0 3\r\n"
			+ "3 5 6\r\n" + "4 3 5\r\n" + "4 5 12\r\n";
}
