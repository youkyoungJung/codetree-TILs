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

    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n;
    static int m;
    static Queue<Location> queue;
    static int cnt = 0;
    static int[][] arr;
    static int[][] isVisited;
    static ArrayList<Location> marbles = new ArrayList<>();

    //1초 후에 어떤 위치에서 어떤 방향을 보는지 상태 반환
    public static Location Move(Location location){
        int r = location.r;
        int c = location.c;
        int dir = location.dir;

        int nx = r + dist[dir][0];
        int ny = c + dist[dir][1];

        if(checked(nx, ny)){
            return new Location(nx, ny, dir);
        }else{
            return new Location(r, c,changeDir(dir));
        }
    }

    //전부 한번씩 이동
    public static void moveAll(){
        for(int i = 0; i < marbles.size(); i++){
            Location current = Move(marbles.get(i));
            marbles.set(i, current);
        }
    }

    // 해당 구슬과 충돌이 일어나는 구슬이 있는 지 확인
    public static boolean duplicateMarbleExist(int targetIdx){
        int targetX = marbles.get(targetIdx).r;
        int targetY = marbles.get(targetIdx).c;

        return arr[targetX][targetY] >= 2;
    }

    //충돌 부분 삭제
    public static void removeDuplicateMarbles(){
        ArrayList<Location> temp = new ArrayList<>();

        //1. 각 구슬의 위치에 count 증가
        for(int i = 0; i < marbles.size(); i++){
            int r = marbles.get(i).r;
            int c = marbles.get(i).c;
            arr[r][c]++;
        }

        //2. 충돌이 일어나지 않는 부분 전부 기록
        for(int i = 0; i < marbles.size(); i++){
            if(!duplicateMarbleExist(i)){
                temp.add(marbles.get(i));
            }
        }

        //3. 나중을 위해 각 구슬의 위치에 적어놓은 count 수 초기화
        for(int i = 0; i < marbles.size(); i++){
            int r = marbles.get(i).r;
            int c = marbles.get(i).c;
            arr[r][c]--;
        }

        //4. 바꿔줌
        marbles = temp;
    }

    public static void simulation(){
        moveAll();
        removeDuplicateMarbles();
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        mapper['U'] = 0;
        mapper['R'] = 1;
        mapper['L'] = 2;
        mapper['D'] = 3;

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n][n];

            marbles= new ArrayList<>();

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                char d = st.nextToken().charAt(0);

                marbles.add(new Location(x, y, mapper[d]));

            } // 바둑알 받기 완료

            for(int test = 1; test <= 2*n; test++){
               simulation();
            }
           
            sb.append(marbles.size()).append("\n");
        }
        System.out.println(sb.toString());

    }
    public static boolean checked(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n;
    }

public static int[] mapper = new int[128];
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