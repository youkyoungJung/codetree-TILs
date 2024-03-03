import java.io.*;
import java.util.*;

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
    static int m;
    static int[][] arr;
    static boolean[][] isVisited;
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static Queue<Location> queue = new ArrayDeque<>();
    static Queue<Location> glacier = new ArrayDeque<>();

    static int time = 0;
    static int lastCnt = 0;

    public static void main(String[] args) throws IOException {
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

        //초기는 0, 0 에서 시작
        queue.offer(new Location(0, 0));
        isVisited[0][0] = true;

        boolean isExist = false;

        do{
            isExist = simulate();
        }while(isExist);

        System.out.println(time + " " + lastCnt);
    }

    public static boolean simulate(){
        bfs();

        if(glacier.size() == 0){ //녹일 빙하가 없다면
            return false;
        }

        time++;
        lastCnt = glacier.size();
        queue = new ArrayDeque<>(glacier);

        melt();
        return true;
    }

    public static void melt(){
        while(!glacier.isEmpty()){
            Location current = glacier.poll();
            arr[current.r][current.c] = 0; //물로 변환
        }
    }

    public static void bfs(){

        while(!queue.isEmpty()){
            Location current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = current.r + dist[i][0];
                int nc = current.c + dist[i][1];

                if(checked(nr, nc)){
                    if(arr[nr][nc] == 0){ //물일 경우
                        queue.offer(new Location(nr, nc));
                    }else{ //빙하일 경우
                        glacier.offer(new Location(nr, nc));
                    }
                    isVisited[nr][nc] = true;
                }
            }
        }
    }

    public static boolean checked(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < m && !isVisited[r][c];
    }
}