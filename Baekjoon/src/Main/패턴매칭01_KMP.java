package Main;

public class 패턴매칭01_KMP {
	public static void main(String[] args) {
		String text = "ABABABACABAABABACACA";
		String pattern = "ABABACA";
	
		KMP(text, pattern);
	} // main
	
	// T : Text
	// P : Pattern
	public static void KMP(String T, String P) {
		int[] pi = getPi(P); // 점프테이블(실패함수테이블) 준비시킨다.
		
		int j = 0; // 패턴의 인덱스
		// i : 본문의 인덱스
		for(int i = 0; i < T.length(); i++) {
			// 달랐을 때
			while(j > 0 && T.charAt(i) != P.charAt(j)) {
				j = pi[j - 1];
			}
			// 같았을 때
			if(T.charAt(i) == P.charAt(j)) {
				// j가 패턴 끝까지 도달했다면...
				if(j == P.length() - 1) {
					System.out.println((i - P.length() + 1) + "위치부터 시작하면 찾을 수 있어요~~");
					j = pi[j];
				} else {
					j++;					
				}
			}
			
		}
	}
	
	// pi : 패턴 P를 i 인덱스까지 잘라서 (부분문자열)
	// 접두사와 접미사가 일치하는 최대 길이를 담을 배열
	public static int[] getPi(String P) {
		int[] pi = new int[P.length()];
		
		int j = 0; // 여기까지는 같아요!
		for(int i = 1; i < P.length(); i++)	{
			// i와 j가 가리키는 값이 다르면...
			while(j > 0 && P.charAt(i) != P.charAt(j))
				j = pi[j - 1];
			
			// i와 j가 가리키는 값이 같다면...
			if(P.charAt(i) == P.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
}
