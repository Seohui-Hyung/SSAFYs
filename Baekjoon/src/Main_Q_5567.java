import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_Q_5567 {
	
	static List<ArrayList<Integer>> people;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 동기 수
		int m = Integer.parseInt(br.readLine()); // 리스트 길이
		int ans = 0;
		
		people = new ArrayList<>();
		
		for(int i = 0; i <= n; i++)
			people.add(new ArrayList<>());
		
		visited = new boolean[n + 1];
		visited[1] = true;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			people.get(start).add(end);
			people.get(end).add(start);
			
		}
		
		bfs(1, 0);
		
		for(int i = 2; i < n + 1; i++) {
			if(visited[i])
				ans++;
		}
		
		System.out.println(ans);
	}

	static void bfs(int start, int depth) {

		if(depth == 2)
			return;
		
		for(int i : people.get(start)) {
			visited[i] = true;
			bfs(i, depth + 1);
		}
		
	}
}
