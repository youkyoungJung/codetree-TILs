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

    static int[][] arr;
    static int n;
    static int m;
    static boolean[][] isVisited;
    static int lastCnt = 0;
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

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

        for(int time = 1; time <= n*m; time++){
            isVisited = new boolean[n][m];

            melt(0, 0);

            if(!hasIce()){ //빙하가 없을 경우 출력
                System.out.println(time + " " + lastCnt);
                break;
            }
        }

    }

    //빙하가 남아있는지 판별
    public static boolean hasIce(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!isVisited[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

    // 빙하 일 경우 bfs
    public static void melt(int r, int c){

        Queue<Location> queue = new ArrayDeque<>();
        isVisited[r][c] = true;
        queue.offer(new Location(r, c));

        int cnt = 0;
        while(!queue.isEmpty()){
            Location current = queue.poll();

            for(int i = 0; i < 4; i++){
                int nr = current.r + dist[i][0];
                int nc = current.c + dist[i][1];

                if(checked(nr, nc)){
                    if(arr[nr][nc] == 1){
                        isVisited[nr][nc] = true;
                        cnt++;
                    }else{
                        isVisited[nr][nc] = true;
                        queue.offer(new Location(nr, nc));
                    }
                }
            }
        }

        lastCnt = cnt;
    }

    public static boolean checked(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < m && !isVisited[r][c];
    }
}