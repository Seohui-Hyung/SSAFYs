import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Q_1592 {
	static int N;
	static int M;
	static int L;
	static int[] rcnt;
	static int total;
	static int i;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		rcnt = new int[N + 1]; // 공 잡은 횟수
		total = 0;
		
		kugel(1);
		
		System.out.println(total);
	}
	
	static void kugel(int i) {
		if (rcnt[i] == M) {
			for (int n = 1; n <= N; n++)
				total += rcnt[n];
			total = total - 1;
			return;
		}
		
		if (rcnt[i] % 2 != 0) {
			if (i + L <= N)
				i = i + L;
			else
				i = i + L - N;
			rcnt[i]++;
		} else {
			if (i - L > 0)
				i = i - L;
			else
				i = i - L + N;
			rcnt[i]++;
		}

		kugel(i);
	}
}
