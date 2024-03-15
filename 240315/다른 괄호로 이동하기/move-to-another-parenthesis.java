import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int a;
    static int b;
    static char[][] board;
    static int[][] dist;

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int INF = (int)1e9;

    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        a = Integer.parseInt(s[1]);
        b = Integer.parseInt(s[2]);
        board = new char[n][n];
        dist = new int[n][n];

        for(int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

//        System.out.println(Arrays.deepToString(board));
        int max = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                init();
                dijkstra(i, j);
                max = Math.max(max, calc());
            }
        }

        System.out.println(max);

    }

    static public void init(){
        //초기화
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], INF);
        }
    }
    static public int calc(){
        int res = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                res = Math.max(res, dist[i][j]);
            }
        }
        return res;
    }
    static public void dijkstra(int r, int c) {
        dist[r][c] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(r, c, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();

            for(int i = 0; i < 4; i++){
                int nx = current.x + dir[i][0];
                int ny = current.y + dir[i][1];

                if(isRange(nx, ny)){
                   if(board[nx][ny] == '('){
                       if(dist[nx][ny] > dist[current.x][current.y] + a){
                           dist[nx][ny] = dist[current.x][current.y] + a;
                            pq.offer(new Node(nx, ny, current.cost + a));
                       }
                   }else {
                       if(dist[nx][ny] > dist[current.x][current.y] + b){
                           dist[nx][ny] = dist[current.x][current.y] + b;
                           pq.offer(new Node(nx, ny, current.cost + b));
                       }
                   }
                }
            }
        }
    }

    static public boolean isRange(int x, int y) {
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