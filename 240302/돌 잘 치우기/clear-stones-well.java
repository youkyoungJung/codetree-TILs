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

    static int n;
    static int k;
    static int m;
    static int[][] arr;
    static boolean[][] isVisited;
    static int answer = Integer.MIN_VALUE;
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static ArrayList<Location> starts;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        starts = new ArrayList<>(k);
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            starts.add(new Location(r, c));
        }

        clearRock(0);
        System.out.println(answer);

    }

    //돌이 있을 경우 치우기
    public static void clearRock(int cnt){
        //기저 조건
        if(cnt == m){
            answer = Math.max(answer, findAnswer());
            return;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 1){
                    arr[i][j] = 0;
                    clearRock(cnt + 1);
                    arr[i][j] = 1;
                }
            }
        }
    }

    public static int findAnswer(){

        int max = Integer.MIN_VALUE;
        isVisited = new boolean[n][n];

        for(int i = 0; i < k; i++){
            Location current = starts.get(i);
            int res = bfs(current.r, current.c);
            max = Math.max(max, res);
        }
        return max;
    }

    //돌 치우고 이동한 수
    public static int bfs(int r, int c){

        int cnt = 1;

        Queue<Location> queue = new ArrayDeque<Location>();
        queue.offer(new Location(r, c));
        isVisited[r][c] = true;

        while(!queue.isEmpty()){
            Location current = queue.poll();

            for(int i = 0; i < 4; i++){
                int nr = current.r + dist[i][0];
                int nc = current.c + dist[i][1];

                if(checked(nr, nc)){
                    isVisited[nr][nc] = true;
                    cnt++;
                    queue.offer(new Location(nr, nc));
                }
            }
        }

        return cnt;
    }

    public static boolean checked(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n && !isVisited[r][c] && arr[r][c] != 1;
    }
}