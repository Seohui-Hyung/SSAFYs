package SWEA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1_팀프로젝트의견조율 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String[] massa = new String[n];
		List<String> same = new ArrayList<>();
		for(int tc = 0; tc < n; tc++) {
			massa[tc] = sc.next();
		}
		for(int tc = 0; tc < m; tc++) {
			String str = sc.next();
			for(String st : massa) {
				if(str.equals(st)) {
					same.add(str);
					System.out.println(str);
				}
			}
		}
		if(same.isEmpty()) System.out.println("NO!!");
	}
}


/*
package code_battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[] ma = new String[N];
        for (int i = 0; i < ma.length; i++) ma[i] = br.readLine();
        
        String[] sam = new String[M];
        for (int i = 0; i < sam.length; i++) sam[i] = br.readLine();
        
        boolean isEqual = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(ma[i].equals(sam[j])) {
                    System.out.println(ma[i]);
                    isEqual = true;
                    continue;
                }
            }
        }
        if(!isEqual) System.out.println("NO!!");
    }

}
 */
