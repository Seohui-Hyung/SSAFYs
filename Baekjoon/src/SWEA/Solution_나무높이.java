package SWEA;
import java.util.Scanner;

public class Solution_나무높이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] height = new int[N];
			int maxheight = 0;
			
			for (int tree = 0; tree < N; tree++) {
				height[tree] = sc.nextInt();
				maxheight = Math.max(maxheight, height[tree]);
			}
			
			int day = 0;
			
			// 시간을 효율적으로 쓰지 못하는 오류......
			// 최고 나무 높이가 홀수인 경우
			if (maxheight % 2 != 0) {
				for (int tree = 0; tree < N; tree++) {
					if (height[tree] == maxheight) // 높이 똑같으면 넘어가기
						continue;
					else if (height[tree] % 2 == 0) { // 나무 높이가 짝수
						day += maxheight - height[tree]; // 이틀에 한 번 높이 +2 증가
						day++; // 그 외 +1 하루
					} else { // 나무 높이가 홀수
						day += maxheight - height[tree]; // 이틀에 한 번 높이 +2 증가
					}
				}
			}
			
			// 최고 나무 높이가 짝수인 경우
			else {
				for (int tree = 0; tree < N; tree++) {
					if (height[tree] == maxheight) // 높이 똑같으면 넘어가기
						continue;
					else if (height[tree] % 2 == 0) { // 나무 높이가 짝수
						day += maxheight - height[tree]; // 이틀에 한 번 높이 +2 증가
					} else { // 나무 높이가 홀수
						day += maxheight - height[tree]; // 이틀에 한 번 높이 +2 증가
						day++; // 그 외 +1 하루
					}
				}
			}
			
			System.out.println("#" + test_case + " " + day);
		}
	}
}
