import java.util.*;
import java.io.*;

public class Main {
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int answer = 1;
    static class Location{
        int r;
        int c;
         
        public Location(int r, int c){
            this.r = r;
            this.c = c;
        } 
    }

    static int[][] arr;
    static int n;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            bfs(r, c);
        }

        System.out.println(answer);
    }

    public static void bfs(int r, int c){
        Queue<Location> queue = new ArrayDeque<>();
        queue.offer(new Location(r, c));
        arr[r][c] = -1;

        while(!queue.isEmpty()){
            Location current = queue.poll();

            for(int i = 0; i < 4; i++){
                int nr = current.r + dist[i][0];
                int nc = current.c + dist[i][1];

                if(checked(nr, nc)){
                    arr[nr][nc] = -1;
                    answer++;
                    queue.offer(new Location(nr, nc));
                }
            }
        }
    }

    public static boolean checked(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n && arr[r][c] != -1 && arr[r][c] != 1;
    }

}