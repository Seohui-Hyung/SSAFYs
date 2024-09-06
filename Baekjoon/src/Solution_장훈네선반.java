import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_장훈네선반 {
	static int N, B;
	static int[] height;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			B = sc.nextInt();
			height = new int[N];
			
			for(int p = 0; p < N; p++) {
				height[p] = sc.nextInt();
			}
			
			List<Integer> current = new ArrayList<>(); // 부분집합 저장하기 위한 리스트
			
			min = Integer.MAX_VALUE;
			pLadder(height, 0, current);
			
			System.out.println("#" + test_case + " " + (min - B));
		}
	}

	private static void pLadder(int[] arr, int index, List<Integer> current) {
		// 기저 조건
		if(!current.isEmpty()) {
			int sum = 0;
			
			for(int num : current) {
				sum += num;
			}
			
			if(sum >= B)
				min = Math.min(min, sum);
		}
		
		// 재귀
		for(int i = index; i < arr.length; i++) {
			current.add(arr[i]); // 원소 선택
			pLadder(arr, i + 1, current); // 다음 원소 처리
			current.remove(current.size() - 1); // 원소 제거
		}
	}
}
