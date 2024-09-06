import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_Q_17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");
		
		StringBuilder sb = new StringBuilder();
		
		List<String> word = new ArrayList<>();
		
		boolean inbracket = false; // 괄호 안에 있는지 여부
		
		for (int i = 0; i < str.length; i++) {
			
			if (str[i].equals("<")) { // < 만나면 지금까지 쌓였던 거 주르륵 빼주기
				for (int j = word.size() - 1; j >= 0; j--) {
					sb.append(word.remove(j));
				}
				inbracket = true;
				sb.append(str[i]);
			} else if (str[i].equals(">")) { // > 만나면 그냥 추가, 괄호 끝
				inbracket = false;
				sb.append(str[i]);
			} else if (inbracket)	{ // < > 안에 있으면 그냥 추가
				sb.append(str[i]);
			} else if (str[i].equals(" ")) { // 띄어쓰기 만나면 쌓였던 거 주르륵 빼주기
				for (int j = word.size() - 1; j >= 0; j--) {
					sb.append(word.remove(j));
				}
				sb.append(" "); // 띄어쓰기는 추가 안 되어 있으니까 
			} else // 관계 없는 글자들은 그냥 추가
				word.add(str[i]);
		}
		
		// 안 빠진 것들 빼주기
		for (int i = word.size() - 1; i >= 0; i--) {
			sb.append(word.remove(i));
		}
		
		System.out.println(sb.toString());	
	}

}
