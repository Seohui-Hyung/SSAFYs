import java.util.*;

public class Main_Q_14503 {    
    
    static int N, M, r, c, direction;
    static int[][] arr;
    static int cnt = 1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        r = sc.nextInt();
        c = sc.nextInt();
        direction = sc.nextInt();
        
        arr = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        clean(r, c, direction);
        System.out.println(cnt);
    }    
    
    public static void clean(int x, int y, int dir) {
        
        arr[x][y] = -1; // 청소하면 -1로 표기
        
        for(int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4; // 반시계 회전
                       
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if(arr[nx][ny] == 0) {
                    cnt++;
                    clean(nx, ny, dir);
                    
                    return;
                }
            }
        }
        
        // 청소되지 않은 빈칸이 없으면 후진
        int d = (dir + 2) % 4;
        int bx = x + dx[d];
        int by = y + dy[d];
        
        if(bx >= 0 && by >= 0 && bx < N && by < M && arr[bx][by] != 1) {
            clean(bx, by, dir);
        }
    }
}