import java.io.*;
import java.util.*;

public class Main {
    static class Location{
        int r;
        int c;
        int cnt;

        public Location(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static int n;
    static int[][] arr;
    static int[][] dist = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
    static int er;
    static int ec;
    static boolean[][] isVisited;


    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        isVisited = new boolean[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken())-1;
        int sc = Integer.parseInt(st.nextToken())-1;
        er = Integer.parseInt(st.nextToken())-1;
        ec = Integer.parseInt(st.nextToken())-1;

        int answer = bfs(sr, sc);
        System.out.println(answer);
    }

    public static int bfs(int r, int c){
        Queue<Location> queue = new ArrayDeque<>();
        queue.offer(new Location(r, c, 0));
        isVisited[r][c] = true;

        while(!queue.isEmpty()){
            Location current = queue.poll();

            if(current.r == er && current.c == ec){
                return current.cnt;
            }

            for(int i = 0; i < dist.length; i++){
                int nr = current.r + dist[i][0];
                int nc = current.c + dist[i][1];

                if(checked(nr, nc)){
                    isVisited[nr][nc] = true;
                    queue.offer(new Location(nr, nc, current.cnt + 1));
                }

            }
        }
        return -1;
    }

    public static boolean checked(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n && !isVisited[r][c];
    }
}