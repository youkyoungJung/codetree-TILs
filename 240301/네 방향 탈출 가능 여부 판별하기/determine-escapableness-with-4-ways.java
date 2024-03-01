import java.util.*;
import java.io.*;

public class Main {

    static int[][] dist = {{-1 , 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n;
    static int m;
    static int[][] arr;

    static class Location{
        int r;
        int c;
        public Location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

       bfs(0, 0);

    }

    public static void bfs(int r, int c){

        Queue<Location> queue = new ArrayDeque<>();
        if(arr[0][0] == 1){
            queue.offer(new Location(r, c));
            arr[r][c] = -1;
        }

        while(!queue.isEmpty()){
            Location current = queue.poll();

            for(int i = 0; i < 4; i++){
                int nr = current.r + dist[i][0];
                int nc = current.c + dist[i][1];

                if(checked(nr, nc)){
                    if(nr == n-1 && nc == m-1){
                        System.out.println(1);
                        return;
                    }
                    arr[nr][nc] = -1;
                    queue.offer(new Location(nr, nc));
                }
            }
        }

        System.out.println(0);

    }

    public static boolean checked(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < m && arr[r][c] != -1 && arr[r][c] != 0;
    }
}