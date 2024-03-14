import java.util.*;
import java.io.*;

public class Main {
    static int n, a, b;
    static String[][] board;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        a = Integer.parseInt(s[1]);
        b = Integer.parseInt(s[2]);
        board = new String[n][n];

        for(int i = 0; i < n; i++) {
            s = br.readLine().split("");
            for(int j = 0; j < s.length; j++) {
                board[i][j] = s[j];
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
                visited = new boolean[n][n];
                dist = new int[n][n];
                for(int k = 0; k < n; k++) {
                    Arrays.fill(dist[k], (int)1e9);
                }
                dist[i][j] = 0;
                pq.offer(new Node(i, j, 0));

                int v = dijkstra(pq);
                res = Math.max(res, v);
            }
        }

        System.out.println(res);
    }
    static int dijkstra(PriorityQueue<Node> pq) {
        int max = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.cost != dist[cur.x][cur.y]) continue;

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(isRange(nx, ny)) {
                    if(board[cur.x][cur.y].equals(board[nx][ny])) {
                        max = getMax(pq, max, cur, nx, ny, a);
                    } else {
                        max = getMax(pq, max, cur, nx, ny, b);
                    }
                }
            }
        }

        return max;
    }

    private static int getMax(PriorityQueue<Node> pq, int max, Node cur, int nx, int ny, int value) {
        if(dist[nx][ny] > dist[cur.x][cur.y] + value) {
            dist[nx][ny] = dist[cur.x][cur.y] + value;
            pq.offer(new Node(nx, ny, cur.cost + value));
            max = Math.max(cur.cost, cur.cost + value);
        }
        return max;
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    static class Node {
        int x, y, cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}