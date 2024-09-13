import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Q_6603 { 
	static int n;
	static int[] arr;
	static int[] set;
	static boolean[] visit;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			n = Integer.parseInt(st.nextToken());
			
			// 0이면 중단
			if(n == 0) break;
			
			// 입력 받은 수 저장
			arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 부분 집합 저장할 배열 생성
			set = new int[6];
			// 방문 체크 배열
			visit = new boolean[n];
			pick(0, 0);
			
			System.out.println(sb);
		}
	}

	static void pick(int start, int depth) {
		if(depth == 6) {
			for(int num : set) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				set[depth] = arr[i];
				pick(i, depth + 1);
				visit[i] = false;
			}
		}
	}

}