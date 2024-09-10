package SWEA;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Microbe {
	int x;
	int y;
	int cnt;
	int dir;
	
	public Microbe(int x, int y, int cnt, int dir) {
		super();
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.dir = dir;
	}	
}

public class Solution_미생물격리 {
	
	static int N, M, K;
	static List<Microbe> mlist;
	static int[] dx = {0, 0, 0, -1, 1}; // 상 하 좌 우
	static int[] dy = {0, 1, -1, 0, 0};
	static int sum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			
			mlist = new ArrayList<>();
			
			for(int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int cnt = sc.nextInt();
				int dir = sc.nextInt();
				
				mlist.add(new Microbe(x, y, cnt, dir));
			}
			
			for(int hour = 0; hour < M; hour++) {
				 position(); // 미생물 이동
				 combine(N); // 군집 합치기
			}
			
			sum = 0;
			
			for(Microbe m : mlist) {
				sum += m.cnt;
			}
			
			System.out.println("#" + test_case + " " + sum);
		}
	}
	
	static void position() { // 함수가 돌면 이동을 함
		for(Microbe m : mlist) {
			m.x += dx[m.dir];
			m.y += dy[m.dir];
			
			// 약품에 닿음
			if(m.x == 0 || m.y == 0 || m.x == N - 1 || m.y == N - 1) {
				m.cnt /= 2; // 절반으로 감소
				
				switch(m.dir) { // 방향 변경
					case 1: m.dir = 2; break;
					case 2: m.dir = 1; break;
					case 3: m.dir = 4; break;
					case 4: m.dir = 3; break;
				}
			}
		}
	}
	
	static void combine(int N) { // 함수가 돌면 합쳐질 애들이 합쳐짐
		int[][] checking = new int[N][N];
		int[][] mcnt = new int[N][N]; // 좌표의 미생물 수
		int[][] mdir = new int[N][N]; // 좌표의 방향
		
		for(Microbe m : mlist) {
			checking[m.x][m.y] += m.cnt; // 특정 좌표에 모이는 미생물 수 누적합
			if(mcnt[m.x][m.y] == 0) { // 아무도 없는 좌표면 미생물 수, 방향 입력
				mcnt[m.x][m.y] = m.cnt;
				mdir[m.x][m.y] = m.dir;
			} else if(mcnt[m.x][m.y] < m.cnt) { // 누가 있으면 값 비교 후 더 큰 값의 방향 따라가기
				mcnt[m.x][m.y] = m.cnt;
				mdir[m.x][m.y] = m.dir;
			}
		}
		
		// 제일 컸던 값 말고 작은 애들의 값을 리스트에서 없애주기
		Iterator<Microbe> itr = mlist.iterator();
		while(itr.hasNext()) {
			Microbe m = itr.next();
			if(checking[m.x][m.y] != m.cnt) { // 우리는 만났어
				for(Microbe tmp : mlist) {
					if(tmp.x == m.x && tmp.y == m.y && tmp.cnt == checking[m.x][m.y] && tmp.dir == m.dir) {
						itr.remove();
						break;
					}
				}
			} else {
				m.cnt = checking[m.x][m.y];
				m.dir = mdir[m.x][m.y];
			}
		}
		
	}
}
