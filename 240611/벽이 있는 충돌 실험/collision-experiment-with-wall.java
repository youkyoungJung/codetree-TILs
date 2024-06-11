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

    static int[][] dist = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //0, 1, 2, 3, 4
    static int n;
    static int m;
    static Queue<Location> queue;
    static int cnt = 0;
    static int[][] arr;
    static int[][] isVisited;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n][n];
            isVisited = new int[n][n];

            queue = new ArrayDeque<>();

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                char d = st.nextToken().charAt(0);

                int dir = 1;
                if(d == 'U'){
                    dir = 1;
                }else if( d == 'D'){
                    dir = 2;
                }else if( d == 'R'){
                    dir = 3;
                }else{
                    dir = 4;
                }
                arr[x][y] = dir;
                isVisited[x][y] = 1;

                queue.offer(new Location(x, y, dir));

            } // 바둑알 받기 완료

            for(int test = 0; test < 2*n; test++){

                move();

                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        if(arr[i][j] > 0 && isVisited[i][j] == 1){
                            queue.offer(new Location(i, j, arr[i][j]));
                        }
                    }
                }
            }
           
            sb.append(queue.size()).append("\n");
        }
        System.out.println(sb.toString());

    }
    public static boolean checked(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static void move(){
         while(!queue.isEmpty()){
                Location current = queue.poll();
                int direction = current.dir;
                int nr = current.r + dist[direction][0];
                int nc = current.c + dist[direction][1];

                if(checked(nr, nc)){
                    // System.out.println("la?");
                    isVisited[current.r][current.c] -= 1;
                    // arr[current.r][current.c] = 0;

                    isVisited[nr][nc] += 1;
                    arr[nr][nc] = direction;
                    
                }else{
                    //방향 바꿔주기
                    direction = changeDir(current.dir);
                    arr[current.r][current.c] = direction;
                }

                // for(int i = 0; i < n; i++){
                //     for(int j = 0; j < n; j++){
                //         System.out.print(arr[i][j] + " ");
                //     }
                //     System.out.println();
                // }
                // System.out.println();
            }
    }

    public static int changeDir(int dir){
        if(dir == 1){//상
            return 2;
        }else if(dir == 2){//하
            return 1;
        }else if(dir == 3){ //좌
            return 4;
        }else{//우
            return 3;
        }
    }
}