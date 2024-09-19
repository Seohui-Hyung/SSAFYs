package SWEA;
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
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
//			int pair = n * (n - 1) / 2; // 쌍의 수
			int sum = 0; // GCD 합
			
			for(int j = 0; j < n - 1; j++) {
				int smaller = Integer.MAX_VALUE; // 쌍에서 더 작은 수 저장할 변수
	
				for(int k = j + 1; k < n; k++) {
					smaller = Math.min(nums[j], nums[k]);
					int gcd = 0;
					
					for(int l = 1; l <= smaller; l++) {
						if(nums[j] % l == 0 && nums[k] % l == 0)
							gcd = l;
					} // for문 다 돌고 나면 최대공약수가 gcd에 저장
					
					sum += gcd;
				}
			}
			
			System.out.println(sum);
		}
	}
}
