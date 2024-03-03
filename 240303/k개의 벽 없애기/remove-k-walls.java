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

        public String toString(){
            return "r: " + r + " c: " + c + " cnt: " + cnt;
        }

    }
    static int n;
    static int k;
    static int[][] arr;
    static boolean[][] isVisited;
    static ArrayList<Location> walls = new ArrayList<>();
    static ArrayList<Location> pickCrush = new ArrayList<>();
    static int sr;
    static int sc;
    static int er;
    static int ec;
    static int answer = Integer.MAX_VALUE;
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //격자의 크기
        k = Integer.parseInt(st.nextToken()); //없애야 할 벽의 개수

        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){ //벽일 경우
                    walls.add(new Location(i, j, 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken())-1;
        sc = Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(br.readLine());
        er = Integer.parseInt(st.nextToken())-1;
        ec = Integer.parseInt(st.nextToken())-1;

        combi(0, 0);
        // k 개의 벽을 없애도 도착점 까지 도달하는 것이 불가능 하다면, -1 출력
        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }

    }

    public static void combi(int idx, int cnt){
        //기저조건
        if(idx == walls.size()){
            if(cnt == k){
                simulation();
            }
            return;
        }

        if(cnt > k) return;

        pickCrush.add(walls.get(idx));
        combi(idx + 1, cnt + 1);

        pickCrush.remove(pickCrush.size()-1);
        combi(idx + 1, cnt);

    }

    public static void simulation(){
        //벽 부수기
        for(int i = 0; i < k; i++){
            Location current = pickCrush.get(i);
            arr[current.r][current.c] = 0;
        }

        //bfs 진행
        // 시작점에서 도착점 까지 이동하는데 걸리는 최소시간
        isVisited = new boolean[n][n];
        int res = bfs(sr, sc);
        answer = Math.min(answer, res);

        //원상 복기
        for(int i = 0; i < k; i++){
            Location current = pickCrush.get(i);
            arr[current.r][current.c] = 1;
        }

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

            for(int i = 0; i < 4; i++){
                int nr = current.r + dist[i][0];
                int nc = current.c + dist[i][1];

                if(checked(nr, nc)){
                    queue.offer(new Location(nr, nc, current.cnt + 1));
                    isVisited[nr][nc] = true;
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    public static boolean checked(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n && !isVisited[r][c] && arr[r][c] == 0;
    }
}