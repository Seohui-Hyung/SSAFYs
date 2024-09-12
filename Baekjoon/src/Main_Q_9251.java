import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_Q_9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String[] A = str.split("");
		
		str = br.readLine();
		String[] B = str.split("");
		
		int[][] dp = new int[B.length + 1][A.length + 1];
		
		for(int i = 0; i < B.length; i++) {
			for(int j = 0; j < A.length; j++) {
				if(B[i].equals(A[j])) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		
		System.out.println(dp[B.length][A.length]);
	}
}
