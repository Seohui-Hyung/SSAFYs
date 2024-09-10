package SWEA;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_하나로 {
    static int[][] island;
    static int[] parent;
    static int size; // 섬 개수
    static double rate; // 환경 부담 세율

    static class Edge {
        int from, to;
        long cost;

        public Edge(int from, int to, long cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            size = Integer.parseInt(br.readLine()); // 섬 개수
            island = new int[size + 1][2]; // 섬 좌표 배열

            for (int n = 1; n <= size; n++) {
                st = new StringTokenizer(br.readLine());
                island[n][0] = Integer.parseInt(st.nextToken());
                island[n][1] = Integer.parseInt(st.nextToken());
            }

            rate = Double.parseDouble(br.readLine()); // 환경 부담 세율

            ArrayList<Edge> edges = new ArrayList<>();

            // 모든 섬 쌍에 대해 간선(거리^2)을 추가
            for (int i = 1; i <= size; i++) {
                for (int j = i + 1; j <= size; j++) {
                    long distanceSquared = (long) (Math.pow(island[i][0] - island[j][0], 2)
                            + Math.pow(island[i][1] - island[j][1], 2));
                    edges.add(new Edge(i, j, distanceSquared));
                }
            }

            // 크루스칼 알고리즘을 위한 간선 정렬
            Collections.sort(edges, new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return Long.compare(o1.cost, o2.cost);
                }
            });

            parent = new int[size + 1];
            for (int i = 1; i <= size; i++) {
                parent[i] = i;
            }

            long totalCost = 0;
            int count = 0;

            for (Edge edge : edges) {
                if (findSet(edge.from) != findSet(edge.to)) {
                    union(edge.from, edge.to);
                    totalCost += edge.cost;
                    count++;
                    if (count == size - 1) break; // MST 완성 시 종료
                }
            }

            // 최종 세금 계산
            long tax = Math.round(totalCost * rate);
            System.out.println("#" + test_case + " " + tax);
        }
    }

    // 있는지 보기
    static int findSet(int x) {
        if (parent[x] != x) {
            parent[x] = findSet(parent[x]); // 경로 압축
        }
        return parent[x];
    }

    // 집합 합치기
    static void union(int x, int y) {
        int rootX = findSet(x);
        int rootY = findSet(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}