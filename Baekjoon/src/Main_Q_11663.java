import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_Q_11663 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 점의 개수
		int M = Integer.parseInt(st.nextToken()); // 선분의 개수
		
		long[] spot = new long[N];
		
		st = new StringTokenizer(br.readLine()); // 점 개수 입력
		
		for(int i = 0; i < N; i++) {
			spot[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(spot);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			long start = Long.parseLong(st.nextToken());
			long end = Long.parseLong(st.nextToken());
			
			int s = lowerBound(spot, start);
			int e = upperBound(spot, end);
			
			System.out.println(e - s);
		}
	}

	// 선분의 시작점 이상인 값이 처음으로 등장하는 위치(인덱스)
	private static int lowerBound(long[] arr, long start) {
		int low = 0;
		int high = arr.length;
		
		while(low < high) {
			int mid = (low + high) / 2;
			
			if(arr[mid] >= start) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	// 선분의 끝점보다 큰 값이 처음으로 등장하는 위치(인덱스)
	private static int upperBound(long[] arr, long end) {
		int low = 0;
		int high = arr.length;
		
		while(low < high) {
			int mid = (low + high) / 2;
			
			if(arr[mid] > end) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}	
}
