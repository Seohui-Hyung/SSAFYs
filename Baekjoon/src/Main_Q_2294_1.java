import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_Q_2294_1 {
	static int n, k;
	static int[] coin; // 각 동천의 종류(가치)를 입력할 배열
	static int[] dp; // 인덱스 값을 합으로 갖는 최소 동전의 수 저장할 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 동전 종류
		k = Integer.parseInt(st.nextToken()); // 원하는 합
		coin = new int[n];
		dp = new int[k + 1];
		Arrays.fill(dp, 100001);
		
		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		calculate();
		
	}

	private static void calculate() {
		
		dp[0] = 0;
		
		for(int i = 0; i < coin.length; i++) {
			for(int j = coin[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
			}
		}
		
		if(dp[k] == 100001)
			dp[k] = -1;
		
		System.out.println(dp[k]);
	}

}