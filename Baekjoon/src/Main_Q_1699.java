import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_Q_1699 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			dp[i] = i; // 최대 개수는 모두 1^2인 경우
			
			for(int j = 1; j * j <= i; j++) {
				if(dp[i] > dp[i - j * j] + 1)
					dp[i] = dp[i - j * j] + 1;
			}
		}
		
		System.out.println(dp[N]);
	}
}