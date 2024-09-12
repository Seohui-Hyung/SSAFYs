import java.util.Scanner;

public class Main_Q_1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] dp = new int[num + 1];
		
		dp[0] = 0;
		dp[1] = 0;
		
		for(int i = 2; i <= num; i++) {
			dp[i] = dp[i - 1] + 1;
			if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
		}
		
		System.out.println(dp[num]);
	}
}