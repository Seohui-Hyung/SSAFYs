package Main;

import java.util.Scanner;

public class 동적계획법03_배낭문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 물건의 개수
		int W = sc.nextInt(); // 배낭의 무게
		
		// 햄버거 다이어트 냄새가 살짝 난다
		int[] weights = new int[N + 1];
		int[] cost = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			cost[i] = sc.nextInt();
		}
		int[][] dp = new int[N + 1][W + 1]; // i번째 물건까지 고려할 거야
		
		// 물건은 한 개씩만 존재
		for(int i = 1; i <= N; i++) {
			// w는 임시 무게
			for(int w = 0; w <= W; w++) {
				// 내가 고려할 물건의 무게가 임시 무게보다 작다면...
				if(weights[i] <= w) {
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i]] + cost[i]);
				} else {
					// 아니라면 이전까지 고민한게 베스트
					dp[i][w] = dp[i- 1][w];
				}
			}
		} // 물건 고려
		
		System.out.println(dp[N][W]);
	}
}
