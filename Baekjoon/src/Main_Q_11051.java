import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Q_11051 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int ans = 1;
		
		ans = mul(N) / (mul(K) * mul(N - K));
		
		System.out.println(ans);
	}

	private static int mul(int n) {
		int m = 1;
		
		for(int i = 1; i <= n; i++) {
			m *= i;
		}
		
		return m;
	}
}
