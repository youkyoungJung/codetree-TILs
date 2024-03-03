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

    static boolean[][] isVisited;
    static int[][] arr;
    static int[][] dist= {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] answer;
    static ArrayList<Location> people = new ArrayList<Location>();
    static ArrayList<Location> desti = new ArrayList<Location>();
    static int n;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); // 격자의 크기
        int h = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 비를 피할 수 있는 공간
        
        arr = new int[n][n];
        answer = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 2){ //사람이 있는 위치
                    people.add(new Location(i, j, 0));
                }else if(arr[i][j] == 3){ //목적지 위치
                    desti.add(new Location(i, j, 0));
                }

            }
        }

        // 0 : 이동할 수 있는 곳
        // 1 : 벽 - 이동할 수 없는 곳
        // 2 : 해당칸에 사람이 서 있음
        // 3 : 해당 공간이 비를 피할 수 있는 곳
        // 칸 움직이는 데 1초 걸림

        for(int i = 0; i < people.size(); i++){
            Location current = people.get(i);
            isVisited = new boolean[n][n];

            int res = bfs(current.r, current.c);
            answer[current.r][current.c] = res;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    } //end of main

    public static int bfs(int r, int c){

        Queue<Location> queue = new ArrayDeque<>();
    
        queue.offer(new Location(r, c, 0));
        isVisited[r][c] = true;

        while(!queue.isEmpty()){
            Location current = queue.poll();

            for(int i = 0; i < desti.size(); i++){
                Location d = desti.get(i);
                if(d.r == current.r && d.c == current.c){
                    return current.cnt;
                }
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
        return -1;
        
    } // end of bfs

    public static boolean checked(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n && !isVisited[r][c] && arr[r][c] != 1;
    }

}//end of class