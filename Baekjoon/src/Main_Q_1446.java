import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Q_1446 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[][] shortcut = new int[n][3];
		
		for(int sc = 0; sc < n; sc++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 3; i++) {
				shortcut[sc][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] road = new int[d + 1];
		
		// 도로 배열 초기화 : 최악의 경우 (지름길 없이 모든 도로 걸어야 되는 상황)
		for(int r = 0; r <= d; r++) {
			road[r] = r;
		}
		 
		// 1부터 d까지 도로를 검사하며 최소 거리를 업데이트
		for(int r = 0; r <= d; r++) {
			
			if(r > 0) {
				// 1키로씩 이동할 때의 최단 거리 계산
				road[r] = Math.min(road[r], road[r - 1] + 1);
			}
			
			for(int i = 0; i < n; i++) {
				if(shortcut[i][1] == r) {
					road[shortcut[i][1]] = Math.min(shortcut[i][1], road[shortcut[i][0]] + shortcut[i][2]);
				}
			}
		}
		
		System.out.println(road[d]);
	}
}
