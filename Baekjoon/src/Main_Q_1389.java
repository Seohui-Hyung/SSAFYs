import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_Q_1389 {
    static List<ArrayList<Integer>> friend;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 유저의 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        friend = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            friend.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            friend.get(start).add(end);
            friend.get(end).add(start);
        }

        int minBacon = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            dist = new int[N + 1];  // 각 사람에 대한 거리 배열
            visited = new boolean[N + 1];
            
            for(int j = 1; j <= N; j++) {
            	dist[j] = Integer.MAX_VALUE;
            }
            
            dist[i] = 0;
            
            dfs(i, 0);
            
            int bacon = 0;
            
            for (int j = 1; j <= N; j++) {
                bacon += dist[j];
            }
            
            if (bacon < minBacon) {
                minBacon = bacon;
                ans = i;
            }
        }

        System.out.println(ans);
    }

    // DFS 구현
    private static void dfs(int start, int depth) {
        visited[start] = true;
        
        for (int neighbor : friend.get(start)) {
        	if (dist[neighbor] > depth + 1) {  // 더 짧은 경로가 있으면 갱신
                dist[neighbor] = depth + 1;
                dfs(neighbor, depth + 1);  // 깊이 증가시켜 재귀 호출
            }
        }
    }
}
