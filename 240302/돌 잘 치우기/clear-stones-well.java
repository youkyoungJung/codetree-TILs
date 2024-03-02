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

    static int n;
    static int k;
    static int m;
    static int[][] arr;
    static boolean[][] isVisited;
    static int answer = Integer.MIN_VALUE;
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static ArrayList<Location> stones = new ArrayList<>();

    static ArrayList<Location> selects = new ArrayList<>();

    static ArrayList<Location> starts;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    stones.add(new Location(i, j));
                }
            }
        }

        starts = new ArrayList<>(k);
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            starts.add(new Location(r, c));
        }

        chooseRock(0, 0);

        System.out.println(answer);

    }

    // 바꿀 돌 뽑기
    public static void chooseRock(int idx, int cnt){
        //기저 조건 돌을 다 봤을 경우
        if(idx == stones.size()){
            if(cnt == m){
                answer = Math.max(answer, findAnswer());
            }
            return;
        }

        //선택
        selects.add(stones.get(idx));
        chooseRock(idx + 1, cnt + 1);
        //비선택
        selects.remove(selects.size() - 1);
        chooseRock(idx + 1, cnt);

    }

    public static int findAnswer(){

        for(int i = 0; i < m; i++){
            arr[selects.get(i).r][selects.get(i).c] = 0;
        }

        isVisited = new boolean[n][n];

        for(int i = 0; i < k; i++){
            Location current = starts.get(i);
            if(!isVisited[current.r][current.c]){
                queue.offer(new Location(current.r, current.c));
                isVisited[current.r][current.c] = true;
            }
        }

        int res = bfs();

        for(int i = 0; i < m; i++){
            arr[selects.get(i).r][selects.get(i).c] = 1;
        }
        
        return res;
    }

    static  Queue<Location> queue = new ArrayDeque<Location>();
    //돌 치우고 이동한 수
    public static int bfs(){

        int cnt = 0;

        while(!queue.isEmpty()){
            Location current = queue.poll();
            cnt++;

            for(int i = 0; i < 4; i++){
                int nr = current.r + dist[i][0];
                int nc = current.c + dist[i][1];

                if(checked(nr, nc)){
                    isVisited[nr][nc] = true;
                    queue.offer(new Location(nr, nc));
                }
            }
        }

        return cnt;
    }

    public static boolean checked(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n && !isVisited[r][c] && arr[r][c] == 0;
    }
}