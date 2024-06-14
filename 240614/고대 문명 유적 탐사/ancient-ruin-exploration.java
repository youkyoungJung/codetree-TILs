import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    // static int[][] temp;
    static int k;
    static int m;
    static int[][] centers = {{1, 1}, {1, 2}, {1, 3},
                              {2, 1}, {2, 2}, {2, 3},
                              {3, 1}, {3, 2}, {3, 3}  }; //중심점

    static class Location implements Comparable<Location> {
        int r;
        int c;
        int num;

        public Location(int r, int c, int num){
            this.r = r;
            this.c = c;
            this.num = num;
        }

        public int compareTo(Location o){
            if(o.r == this.r){
                return Integer.compare(o.c, this.c);
            }
            return Integer.compare(this.r, o.r);
        }
    }
    static Location location;
    static Queue<Integer> newOne = new ArrayDeque<>();
    static int value;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        k = Integer.parseInt(st.nextToken()); // 탐사의 반복 횟수
        m = Integer.parseInt(st.nextToken()); // 유물 조각 개수

        arr = new int[5][5];
        // newOne = new int[m];

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            newOne.offer(Integer.parseInt(st.nextToken()));
            // newOne[i] = Integer.parseInt(st.nextToken());
        }

        while(k-- > 0){//탐사 반복

            value = 0;
            simulation();
            sb.append(value).append(" ");

        }

        System.out.println(sb.toString());
    
    }

    public static void search(){ // 가장많이 터지는 위치 탐지
        location = new Location(-1, -1, -1);

        Queue<Location> queue = new ArrayDeque<>();
        for(int i = 0; i < 9; i++){
            int r = dist[i][0];
            int c = dist[i][1];
            queue.offer(new Location(r, c, arr[r][c]));
        }

        while(!queue.isEmpty()){
            Location current = queue.poll();

            for(int i = 0; i < 3; i++){
                goRot(current.r, current.c); //배열 돌리기
                goCon();//조각 3개 이상 연결된 경우 찾기
            }
        }

    }

    public static void goRot(int r, int c){ // 90도 회전 하는 함수
        
        int[][] temp = new int[5][5];

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(i >= r-1 && i <= r+1 && j >=c-1 && j <= c+1){
                    temp[i][j] = arr[2-j][i];
                }
            }
        }

        temp = arr;        
        
    }

    static boolean[][] isVisited;

    public static void goCon(){ //bfs
        isVisited = new boolean[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(!isVisited[i][j]){
                    bfs(i, j);
                }
            }
        }
    }

    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static ArrayList<Location> list = new ArrayList<>();

    public static void bfs(int r, int c){
        
        Queue<Location> queue = new ArrayDeque<>();
        ArrayList<Location> temp = new ArrayList<>();
        queue.offer(new Location(r, c, arr[r][c]));
        isVisited[r][c] = true;

        int number = arr[r][c];
        int cnt = 0;

        while(!queue.isEmpty()){
            Location current = queue.poll();

            for(int i = 0; i < 4; i++){
                int nr = current.r + dist[i][0];
                int nc = current.c + dist[i][1];

                if(checked(nr, nc)){
                    if(number == arr[nr][nc]){
                        cnt++;
                        isVisited[nr][nc] = true;
                        temp.add(new Location(nr, nc, arr[nr][nc]));
                        queue.offer(new Location(nr, nc, 0));
                    }
                }
            }
        }

        if(cnt >= 3){
            if(value < cnt){
                list = temp;
                value = cnt;
                location.r = r;
                location.c = c;
                location.num = temp[r][c];
            }
        }
    }

    public static boolean checked(int nr, int nc){
        return nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && !isVisited[nr][nc];
    }

    public static void simulation(){
        search();
        remove(); // 폭발하면서 value 값 올리기 
    }

    public static void remove(){
       
        for(int i = 0; i < list.size(); i++){
            Location current = list.get(i);
            int r = current.r;
            int c = current.c;
            value += arr[r][c];
            arr[r][c] = 0;
            arr[r][c] = newOne.poll();
        }

    }
}