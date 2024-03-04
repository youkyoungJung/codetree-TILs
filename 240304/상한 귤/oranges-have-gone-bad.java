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
    }
    static int n;
    static int k;
    static int[][] arr;
    static boolean[][] isVisited;
    static int[][] answer; 
    static ArrayList<Location> goBad = new ArrayList<>();
    static Queue<Location> queue = new ArrayDeque<>();
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //격자 크기
        k = Integer.parseInt(st.nextToken()); //k 개의 상한 귤
        arr = new int[n][n];
        isVisited = new boolean[n][n];
        answer = new int[n][n];

        //1초에 한번씩 인접한 귤들이 상함
        //0: 해당 칸에 아무 것도 놓여있지 않음
        //1: 해당 칸에 귤이 놓여있음
        //2: 해당칸에 상한 귤이 처음부터 놓여있음

        //answer 배열 
        //-1 : 처음부터 비어있던 칸
        //-2 : 끝까지 상하지 않는 귤

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){ //상한 귤
                    goBad.add(new Location(i, j, 0));
                }else if(arr[i][j] == 0){ //처음부터 비어 있는 칸
                    answer[i][j] = -1;
                }
            }
        } // 입력 완료

        // 상한 귤 큐에 넣기
        for(int i = 0; i < k; i++){
            Location orange = goBad.get(i);
            queue.offer(orange);
            isVisited[orange.r][orange.c] = true;
        }

        bfs();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!isVisited[i][j]){
                    answer[i][j] = -2;
                }
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    } //end of main

    public static void bfs(){

        while(!queue.isEmpty()){
            Location current = queue.poll();
            answer[current.r][current.c] = current.cnt;

            for(int i = 0; i < 4; i++){
                int nr = current.r + dist[i][0];
                int nc = current.c + dist[i][1];

                if(checked(nr, nc)){
                    isVisited[nr][nc] = true;
                    if(arr[nr][nc] == 1){
                        queue.offer(new Location(nr, nc, current.cnt + 1));
                    }
                }
            }
            
        }
    } // end of bfs

    public static boolean checked(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n && !isVisited[r][c];
    }

}//end of class