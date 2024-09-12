package Main;

import java.util.Arrays;
import java.util.Scanner;

public class 동적계획법01_피보나치 {
	static int[] callFibo = new int[1000];
	static int[] memo; // 계산 값을 저장하기 위한 공간을 할당
	
	static { // 미리 계산해서 올려놔! 라는 작업
		memo = new int[1000];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 음수는 들어오지 않아!
		int N = sc.nextInt();

		System.out.println(fibo3(N));
		System.out.println(fibo2(N));
		System.out.println(fibo1(N)); // 좀 느림
//		System.out.println(Arrays.toString(callFibo));
	}
	
	public static long fibo3(int n) { // DP
		// 처리할 값이 21억을 넘을 것 같으면 long 처리해야 한다.
		long[] dp = new long[n + 1];
		dp[0] = 0;
	 	dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		return dp[n];
	}
	
	
	public static int fibo2(int n) { // Memoization
//		if(n >= 2 && memo[n] == 0)
		if(memo[n] == -1)
			memo[n] = fibo2(n - 1) + fibo2(n - 2);
		return memo[n];
	}
	

	private static int fibo1(int n) { // 일반 재귀
		callFibo[n]++;
		// 기저조건 n == 0 : 0을 반환 / n == 1 : 1을 반환
//		if(n <= 1) return n;
		if(n < 2) return n;
		
		return fibo1(n - 1) + fibo1(n - 2);
	}
}