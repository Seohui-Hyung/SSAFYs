import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Q_9613 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int[] nums = new int[n]; // 받은 수 저장할 배열
			
			for(int j = 0; j < n; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}

			int sum = 0; // GCD 합
			
			for(int j = 0; j < n - 1; j++) {
				for(int k = j + 1; k < n; k++) {
					sum += gcd(nums[j], nums[k]);
				}
			}
			
			System.out.println(sum);
		}
	}
	
	static int gcd(int a, int b) { // 유클리드
		
		while(b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		
		return a;
	}
}
