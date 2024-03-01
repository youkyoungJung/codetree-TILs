import java.util.*;
import java.io.*;

public class Main {

    static class Location implements Comparable<Location>{
        int r;
        int c;
        int val;
        int cnt;

        public Location(int r, int c, int val, int cnt){
            this.r = r;
            this.c = c;
            this.val = val;
            this.cnt = cnt;
        }

        public int compareTo(Location o){
            return Integer.compare(o.val, this.val); //내림차순
        }
    }

    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n;
    static int k;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken()) - 1; //시작 행
        int sc = Integer.parseInt(st.nextToken()) - 1; //시작 열

        bfs(sr, sc);

    }

    public static void bfs(int r, int c){

        PriorityQueue<Location> queue = new PriorityQueue<>();
        queue.offer(new Location(r, c, arr[r][c], 0));
        arr[r][c] = -1;

        while(!queue.isEmpty()){
            Location current = queue.poll();

            if(current.cnt == k){
                System.out.println(current.r + " " + current.c);
                return;
            }

            for(int i = 0; i < 4; i++){
                int nr = current.r + dist[i][0];
                int nc = current.c + dist[i][1];

                if(checked(nr, nc)){
                    if(current.val > arr[nr][nc]){
                        queue.offer(new Location(nr, nc, arr[nr][nc], current.cnt + 1));
                        arr[nr][nc] = -1; //방문 처리
                    }
                }
            }
        }

    }

    public static boolean checked(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n && arr[r][c] != -1;
    }
}