import java.util.Scanner;

public class Solution_나무높이2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] height = new int[N];
			int maxheight = 0;
			int odd = 0;
			int even = 0;
			
			for (int tree = 0; tree < N; tree++) {
				height[tree] = sc.nextInt();
				maxheight = Math.max(maxheight, height[tree]);
			}
			
			int sum = 0; // 키워야 하는 키 총량
			
			for (int tree = 0; tree < N; tree++) {
				int diff = maxheight - height[tree];
				sum += diff;
				
				if (diff % 2 != 0)
					odd++;
				else
					even++;
			}
			
			int mindays = 0;
			int min = Math.min(odd, even);
			
//			if () {
//				mindays += (sum / 3) * 2; // +1일 되는 날과 +2일 되는 날을 한 쌍으로 봄
//				sum %= 3; // 쌍이 되지 않는 남는 날 확인
//				
//				if (sum == 1) {
//					mindays += 1; // +1 (홀수)
//				} else if (sum == 2) {
//					mindays += 2; // 0 +2 (짝수)
//				}
//			}

			System.out.println("#" + test_case + " " + mindays);
		}
		
		sc.close();
	}
}
