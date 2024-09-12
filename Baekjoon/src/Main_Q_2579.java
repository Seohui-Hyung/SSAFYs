import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_Q_2579 {
	static int[] dp;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		dp = new int[n + 1];
		arr = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			dp[i] = Integer.parseInt(br.readLine());
		}
		
		arr[1] = dp[1];

		if(n >= 2) {
			arr[2] = dp[1] + dp[2];
		}
		
		System.out.println(find(n));
	}
	
	static int find(int N) {
		
		if(arr[N] == 0 && N != 0) {
			arr[N] = Math.max(find(N - 2), find(N - 3) + dp[N - 1]) + dp[N];
		}
		
		return arr[N];
	}
}
