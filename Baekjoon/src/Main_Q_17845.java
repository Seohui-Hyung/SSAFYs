import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Q_17845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 서윤이 최대 공부시간
		int K = Integer.parseInt(st.nextToken()); // 과목 수
		int[] I = new int[K + 1];
		int[] T = new int[K + 1];
		int[][] dp = new int[K + 1][N + 1];
		
		for(int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			I[i] = Integer.parseInt(st.nextToken()); // 중요도 I
			T[i] = Integer.parseInt(st.nextToken()); // 공부시간 T
		}
		
		for(int i = 1; i <= K; i++) {
			for(int j = 1; j <= N; j++) {
				if(T[i] <= j) {
					  
				}
			}
		}
		
		System.out.println(dp[K][N]);
	}
}
