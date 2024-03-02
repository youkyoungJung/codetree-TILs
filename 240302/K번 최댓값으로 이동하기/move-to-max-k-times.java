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

    static int[][] dist = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int n;
    static int k;
    static int[][] arr;
    static Location NOT_EXISTS = new Location(-1, 1);

    static Location currCell;

    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken()); //시작 행
        int sc = Integer.parseInt(st.nextToken()); //시작 열
        currCell = new Location(sr, sc);

        while(k-- > 0){
            boolean isMoved = move();

            if(!isMoved) {
                break;
            }
        }

        System.out.println(currCell.r + " " + currCell.c);

    }

    public static boolean move(){
        isVisited = new boolean[n+1][n+1];
        bfs(currCell.r, currCell.c);

        Location bestPos = NOT_EXISTS;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j < n; j++){
                if(!isVisited[i][j] || i == currCell.r && j == currCell.c){
                    continue;
                }

                Location newPos = new Location(i, j);
                if(needUpdate(bestPos, newPos)){
                    bestPos = newPos;
                }
            }
        }
        
        if(bestPos.r == NOT_EXISTS.r && bestPos.c == NOT_EXISTS.c){
            return false;
        }else{
            currCell = bestPos;
            return true;
        }
    }

    public static void bfs(int r, int c){

        Queue<Location> queue = new ArrayDeque<>();
        queue.offer(new Location(r, c));
        isVisited[r][c] = true;
        int targetNum = arr[r][c];

        while(!queue.isEmpty()) {
            Location current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dist[i][0];
                int nc = current.c + dist[i][1];

                if (checked(nr, nc, targetNum)) {
                    isVisited[nr][nc] = true;
                    queue.offer(new Location(nr, nc));
                }
            }
        }
    }

    public static boolean needUpdate(Location bestPos, Location newPos){
        //첫 도달 가능한 위치 : update 필요
        if(bestPos.r == NOT_EXISTS.r && bestPos.c == NOT_EXISTS.c){
            return true;
        }

        if(arr[newPos.r][newPos.c] != arr[bestPos.r][bestPos.c]){
            return arr[newPos.r][newPos.c] > arr[bestPos.r][bestPos.c];
        }
        if(-newPos.r != -bestPos.r){
            return -newPos.r > -bestPos.r;
        }
        return -newPos.c > bestPos.c;
    }
    public static boolean checked(int r, int c, int targetNum){
        return r >= 1 && r <= n && c >= 1 && c <= n && !isVisited[r][c] && arr[r][c] < targetNum;
    }
}