import java.util.*;
import java.io.*;

public class Main {

    static class Location {
        int r;
        int c;

        public Location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static int n;
    static int k;
    static int u;
    static int d;

    static int[][] arr;
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] isVisited;
    static int[] num = new int[2];
    static int answer = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        isVisited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        per(0);
        System.out.println(answer);
    }//end of main

    public static void per(int cnt){
        //기저조건
        if(cnt == 2){
            // System.out.println(Arrays.toString(num));
            isVisited = new boolean[n][n];
            answer = Math.max(answer, goArea());
            return;
        }

        for(int i = 0; i < n; i++){
            num[cnt] = i;
            per(cnt + 1);
        }
    } //end of per

    public static int goArea(){

        int cnt = 1;
        Queue<Location> queue = new ArrayDeque<>();
        queue.offer(new Location(num[0], num[1]));
        isVisited[num[0]][num[1]] = true;

        while(!queue.isEmpty()){
            Location current = queue.poll();

            for(int i = 0; i < 4; i++){
                int nr = current.r + dist[i][0];
                int nc = current.c + dist[i][1];

                if(checked(nr, nc)){
                    if(canGo(current, nr, nc)){
                        queue.offer(new Location(nr, nc));
                        cnt++;
                    }
                    isVisited[nr][nc] = true;
                }
            }
        }
        return cnt;
    }//end of goArea

    public static boolean checked(int nr, int nc){
        return nr >= 0 && nr < n && nc >= 0 && nc < n && !isVisited[nr][nc];
    }//end of checked

    public static boolean canGo(Location current, int nr, int nc){
        int currVal = arr[current.r][current.c];
        int nexVal = arr[nr][nc];

        int diff = Math.abs(currVal - nexVal);

        return diff >= u && diff <= d;
    }//end of canGo

}//end of class