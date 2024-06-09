import java.util.*;
import java.io.*;

public class Main {
    static class Location{
        int r;
        int c;

        public Location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n;
    static int m;
    static int t;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        int[][] arr2 = new int[n][n]; //copy 배열

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        Queue<Location> queue = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            queue.offer(new Location(r, c));
        }

        int cnt = 0;
        while(t-- > 0){

            while(!queue.isEmpty()){
                Location current = queue.poll();
                int r = current.r;
                int c = current.c;

                Location maxL = new Location(-1, -1);
                int maxN = Integer.MIN_VALUE;

                for(int i = 0; i < 4; i++){
                    int nr = r + dist[i][0];
                    int nc = c + dist[i][1];

                    if(checked(nr, nc)){
                        if(arr[r][c] < arr[nr][nc] && maxN < arr[nr][nc]){
                            maxN = arr[nr][nc];
                            maxL.r = nr;
                            maxL.c = nc;
                        }
                    }
                }
                arr2[maxL.r][maxL.c] += 1;

            } //end of queue

            cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(arr2[i][j] > 1){
                        arr2[i][j] = 0;
                        // System.out.println("i: " + i + " j: "+j);
                    }else if(arr2[i][j] == 1){
                        queue.offer(new Location(i, j));
                        // System.out.println("i: " + i + " j: "+j);
                        cnt++;
                    }
                }
            }

        }
        
        System.out.println(cnt);
    }

    static boolean checked(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}