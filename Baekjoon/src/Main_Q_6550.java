import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Q_6550 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			String str = br.readLine();
			if(str == null) break;
			st = new StringTokenizer(str, " ");

			String s = st.nextToken();
			String t = st.nextToken();
			
			int cnt = 0; // 일치하는 글자 수
			int now = 0; // 현재까지 검사한 글자 위치를 저장하기 위한 변수
			
			for(int i = 0; i < t.length(); i++) {
				if(s.charAt(now) == t.charAt(i)) {
					cnt++;
					now++;
					if(now == s.length()) break;
				}
			}
			
			if(cnt == s.length()) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
