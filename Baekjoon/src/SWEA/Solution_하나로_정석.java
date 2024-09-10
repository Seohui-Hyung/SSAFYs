// Kruskal
package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Solution_하나로_정석 {
    static class Edge implements Comparable<Edge>{
        int from, to;
        long cost;
        public Edge(int from, int to, long cost) {
            super();
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge e) {
            return Long.compare(this.cost, e.cost);
        }
    }
    static int[] root;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            long[] x = new long[N]; // x, y자체는 long의 범위가 아니지만 cost을 계산할 때 long의 범위가 필요 
            long[] y = new long[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) x[i] = Integer.parseInt(st.nextToken()); // x좌표
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) y[i] = Integer.parseInt(st.nextToken()); // y좌표
            double E = Double.parseDouble(br.readLine());
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for (int from = 0; from < N; from++) {// index을 node로 설정
                for (int to = from + 1; to < N; to++) {
                    // L계산시 x, y가 int였다면 제곱과정에서 int범위를 넘어서므로 이상한 값이 나옴
                    long L = (x[from]-x[to])*(x[from]-x[to])+(y[from]-y[to])*(y[from]-y[to]);
                    pq.offer(new Edge(from, to, L));
                }
            }
            root = new int[N]; // root node MakeSet
            for (int i = 0; i < N; i++) root[i] = i;
            long costSum = 0;
            int cnt = 0;
            while(cnt != N - 1) {
                Edge e = pq.poll();
                if(find(e.from) == find(e.to)) continue; // Disjoint Sets인지 확인
                union(e.from, e.to); // 두 집합 합치기
                costSum += e.cost;
                cnt++;
            }
            sb.append("#").append(tc).append(" ").append(Math.round(E*costSum)).append("\n");
        }
        System.out.println(sb);
    }
    static int find(int x) { // root node 찾기, Path Compression
        if(root[x] == x) return x;
        else return root[x] = find(root[x]);
    }
    static void union(int x, int y) { // 합치기
        x = find(x);
        y = find(y);
        root[y] = x;
    }
}