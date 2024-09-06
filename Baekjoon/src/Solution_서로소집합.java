import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_서로소집합 {
    static int[] parent;
    static int[] rank;
    static int size, line;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            line = Integer.parseInt(st.nextToken());
            
            parent = new int[size+1];
            rank = new int[size+1];
            
            for(int i = 1; i <= size; i++) {
                parent[i] = i;
                rank[i] = 1; // 초기 rank는 1로 설정
            }
            
            sb.append("#").append(test_case).append(" ");
            for(int i = 0; i < line; i++) {
                st = new StringTokenizer(br.readLine());
                int operation = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                if (operation == 0) {
                    union(a, b);
                } else {
                    if(findSet(a) == findSet(b)) sb.append(1);
                    else sb.append(0);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    static int findSet(int x) {
        if(parent[x] != x) {
            parent[x] = findSet(parent[x]); // 경로 압축
        }
        return parent[x];
    }
    
    static void union(int x, int y) {
        int rootX = findSet(x);
        int rootY = findSet(y);
        
        if (rootX != rootY) {
            if(rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if(rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
