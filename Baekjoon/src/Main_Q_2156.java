import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_Q_2156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[n + 1];
		int[] dp = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = wine[1];
		
		if(n == 1) {
			System.out.println(dp[1]); // 한 잔 밖에 없는 경우
			return;
		}
		
		if(n > 1) dp[2] = wine[1] + wine[2];
		
		for(int i = 3; i <= n; i++) {
			// i번째 잔 안 마심 vs ((i-1)번째 잔 안 마시고 i번째 마심 vs (i-1)번째랑 i번째 마시고 (i-2)번째 안 마심))
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i -3] + wine[i - 1] + wine[i]));
		}
		
		System.out.println(dp[n]);
	}
}