import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Q_11051_P {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = binomial(n, k);

        System.out.println(result);
    }

    // 이항계수를 계산
    private static int binomial(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        // DP 배열 초기화
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i <= k; i++) {
            dp[i][i] = 1;
        }

        // 이항계수 계산
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % 10007;
            }
        }

        return dp[n][k];
    }
}