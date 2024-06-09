import java.util.*;
import java.io.*;

public class Main {
    static class Location {
        int r;
        int c;
        int dir;

        public Location(int r, int c, int dir){
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //0, 1, 2, 3
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];

            Queue<Location> queue = new ArrayDeque<>();

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                char d = st.nextToken().charAt(0);

                int dir = 0;
                if(d == 'U'){
                    dir = 0;
                }else if( d == 'D'){
                    dir = 1;
                }else if( d == 'R'){
                    dir = 2;
                }else{
                    dir = 3;
                }
                arr[x][y] = 1;
                queue.offer(new Location(x, y, dir));

            } // 바둑알 받기 완료

            while(!queue.isEmpty()){
                Location current = queue.poll();
                int nr = current.r + dist[current.dir][0];
                int nc = current.c + dist[current.dir][1];

                if(checked(nr, nc)){
                    arr[current.r][current.c] -= 1;
                    arr[nr][nc] += 1;
                }else{
                    //방향 바꿔주기
                    changeDir(current.dir);
                }
            }

            int cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(arr[i][j] == 1){
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());

    }
    public static boolean checked(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n;
    }
    public static int changeDir(int dir){
        if(dir == 0){//상
            return 1;
        }else if(dir == 1){//하
            return 0;
        }else if(dir == 2){ //좌
            return 3;
        }else{//우
            return 2;
        }
    }
}