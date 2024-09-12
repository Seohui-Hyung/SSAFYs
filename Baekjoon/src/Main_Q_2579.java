import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_Q_2579 {
	static int[] dp; // 각 계단의 점수를 저장하는 배열
	static int[] arr; // 각 계단까지 얻을 수 있는 최대 점수를 저장하는 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		dp = new int[n + 1]; // 계단 점수
		arr = new int[n + 1]; // 최대 점수
		
		for(int i = 1; i <= n; i++) {
			dp[i] = Integer.parseInt(br.readLine());
		}
		
		arr[1] = dp[1]; // 1번째 계단의 최대 점수는 그냥 거기 점수

		if(n >= 2) {
			arr[2] = dp[1] + dp[2]; // 2번째 계단의 최대 점수는 1+2계단
		}
		
		System.out.println(find(n));
	}
	
	static int find(int N) {
		
		if(arr[N] == 0 && N != 0) {
			// n-2번째 계단에서 두 칸을 뛰어넘어 오는 경우
			// n-3번째 계단에서 한 칸을 건너 뛰고, n-1번째 계단을 밟고 오는 경우
			// 둘 중 큰 값 반영해서 저장
			arr[N] = Math.max(find(N - 2), find(N - 3) + dp[N - 1]) + dp[N];
		}
		
		return arr[N];
	}
}
