import java.util.Arrays;
import java.util.Scanner;

class Main {
     
    static int N; // 집 개수
    static int target;
    static int[][] rgb, find; // 각 집을 칠하는 비용, 최적의 비용
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        
        rgb = new int[N][3]; // 빨초파
        
        for(int i = 0; i < rgb.length; i++) {
            for(int j = 0; j < 3; j++) {
                rgb[i][j] = sc.nextInt();
            }
        }
        
        find = new int[N][3]; // 최적 비용 배열
        
        find[0] = rgb[0]; // 첫 번째 집은 그냥 입력 받은 거
        
        find[1][0] = Math.min(find[0][1], find[0][2]) + rgb[1][0]; // 두번째집 빨강
        find[1][1] = Math.min(find[0][0], find[0][2]) + rgb[1][1]; // 두번째집 초록
        find[1][2] = Math.min(find[0][0], find[0][1]) + rgb[1][2]; // 두번째집 파랑
        
        findshort(2); // 세 번째 집부터 최적 비용 계산
        
        int[] result = Arrays.copyOf(find[N-1], 3); // 마지막 집에서 얻은 비용 배열 복사
        
        Arrays.sort(result); // 최소 비용 찾기
        
        System.out.println(result[0]);
        
    }
    
    static void findshort(int idx) {
        if(N == idx) return; // 모든 집 다 칠하면 종료
        if(find[idx][0] == 0) {
            find[idx][0] = Math.min(find[idx-1][1], find[idx-1][2]) + rgb[idx][0];
            find[idx][1] = Math.min(find[idx-1][0], find[idx-1][2]) + rgb[idx][1];
            find[idx][2] = Math.min(find[idx-1][0], find[idx-1][1]) + rgb[idx][2];
        }
        findshort(idx+1);
    }
    
    
}