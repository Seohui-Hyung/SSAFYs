import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Q_6236 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] budget = new int[N];
		
		int min = 1; // 최소 인출 금액
		int max = 1000000000; // 초기 최대 인출 금액
		
		for(int i = 0; i < N; i++) {
			budget[i] = Integer.parseInt(br.readLine());
			min = Math.max(min, budget[i]); // 최소 인출 금액 계산
		}
		
		int ans = max; // 정답 초기화, 큰값으로 설정
		
		// 이분 탐색 이용
		while(min <= max) {
			int mid = (min + max) / 2; 
			
			int cnt = 1; // 인출 횟수 초기화
			int sum = budget[0]; // 첫 날 지출로 초기화
			
			for(int i = 1; i < N; i++) {
				if(sum + budget[i] > mid) { // 현재 인출 한도 초과
					cnt++; // 인출 횟수 증가
					sum = 0; // 인출 한 번 더 해서 다시 초기화
				}
				sum += budget[i]; // 지출 더하기
			}
			
			if(cnt > M) {
				min = mid + 1; // 인출 횟수가 초과되면, 최소 인출 금액 올리기
			} else {
				ans = Math.min(ans, mid); // 최소값 갱신
				max = mid - 1; // 더 낮은 인출 금액 찾기
			}
		}
		
		System.out.println(ans);
	}
}
