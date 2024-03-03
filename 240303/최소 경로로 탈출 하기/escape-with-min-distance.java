import java.util.*;
import java.io.*;

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
    static int m;
    static int[][] arr;
    static boolean[][] isVisited;
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        isVisited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0);
        if(!flag){
            System.out.println(-1);
        }

    }
    public static void bfs(int r, int c){
        Queue<Location> queue = new ArrayDeque<>();
        queue.offer(new Location(r, c, 0));
        isVisited[r][c] = true;

        while(!queue.isEmpty()){
            Location current = queue.poll();

            for(int i = 0; i < 4; i++){
                int nr = current.r + dist[i][0];
                int nc = current.c + dist[i][1];

                if(checked(nr, nc)){
                    isVisited[nr][nc] = true;
                    queue.offer(new Location(nr, nc, current.cnt + 1));
                    if(nr == n-1 && nc == m-1){
                        System.out.println(current.cnt + 1);
                        flag = true;
                        return;
                    }
                }
            }
        }
    }

    public static boolean checked(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < m && !isVisited[r][c] && arr[r][c] != 0;
    }
}