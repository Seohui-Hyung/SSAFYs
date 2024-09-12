import java.util.Scanner;

public class Main_Q_2096_메모리삭제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        
        // 이전 행의 최대/최소 값을 저장하는 배열
        int[] prevMin = new int[3];
        int[] prevMax = new int[3];
        
        // 현재 행의 최대/최소 값을 저장하는 배열
        int[] curMin = new int[3];
        int[] curMax = new int[3];

        // 첫 번째 행 처리 (초기화)
        for (int j = 0; j < 3; j++) {
            int num = sc.nextInt();
            prevMin[j] = num;
            prevMax[j] = num;
        }

        // 나머지 행 처리
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int num = sc.nextInt();

                if (j == 0) {
                    curMax[j] = Math.max(prevMax[0], prevMax[1]) + num;
                    curMin[j] = Math.min(prevMin[0], prevMin[1]) + num;
                } else if (j == 1) {
                    curMax[j] = Math.max(Math.max(prevMax[0], prevMax[1]), prevMax[2]) + num;
                    curMin[j] = Math.min(Math.min(prevMin[0], prevMin[1]), prevMin[2]) + num;
                } else {
                    curMax[j] = Math.max(prevMax[1], prevMax[2]) + num;
                    curMin[j] = Math.min(prevMin[1], prevMin[2]) + num;
                }
            }
            // 현재 행의 결과를 이전 행으로 복사
            prevMax = curMax.clone();
            prevMin = curMin.clone();
        }

        // 최종 결과 계산
        int max = Math.max(Math.max(prevMax[0], prevMax[1]), prevMax[2]);
        int min = Math.min(Math.min(prevMin[0], prevMin[1]), prevMin[2]);

        System.out.println(max + " " + min);
    }
}