import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Q_6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str;
        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str, " ");

            String s = st.nextToken();
            String t = st.nextToken();

            int now = 0; // 현재까지 검사한 글자 위치를 저장하기 위한 변수

            for (int i = 0; i < t.length(); i++) {
                if (now < s.length() && s.charAt(now) == t.charAt(i)) {
                    now++;
                    if (now == s.length()) break;
                }
            }

            if (now == s.length()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}