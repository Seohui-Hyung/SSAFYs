import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_Q_17419 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String K = br.readLine();
		int cnt = 0;
		
		for(int i = 0; i < K.length(); i++) {
			if(K.charAt(i) == '1') {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
