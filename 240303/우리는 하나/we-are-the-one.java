import java.util.*;
import java.io.*;

public class Main {

    static class Location {
        int r;
        int c;

        public Location(int r, int c){
            this.r = r;
            this.c = c;
        }

        public String toString(){
            return "Location[r=" + r +" , c=" + c + "]";
        }
    }

    static int n;
    static int k;
    static int u;
    static int d;
    static int[][] arr;
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] isVisited;
    static int[] num = new int[2];
    static int answer = Integer.MIN_VALUE;
    static Queue<Location> queue = new ArrayDeque<>();
    static ArrayList<Location> nums = new ArrayList<>();
    static ArrayList<Location> selects = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        per(0);
        combi(0, 0);

        System.out.println(answer);
    }//end of main

    public static void simulation() {
        int cnt = 0;

        isVisited = new boolean[n][n];
        for (int i = 0; i < k; i++) {
            int r = selects.get(i).r;
            int c = selects.get(i).c;

            queue.offer(new Location(r, c));
            isVisited[r][c] = true;
            goArea();
        }
        cnt = calc();

        if(answer < cnt){
            answer = cnt;
        }
    }

    public static int calc(){
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isVisited[i][j]) cnt++;
            }
        }
        return cnt;
    }

    //구해진 nums(Location) 중 k 개 뽑기
    public static void combi(int idx, int cnt){
        //기저조건
        if(idx == nums.size()){
            if(cnt == k){
                simulation();
            }
            return;
        }

        if(cnt > k) return;

        //선택
        selects.add(nums.get(idx));
        combi(idx + 1, cnt+1);
        //비선택
        selects.remove(selects.size()-1);
        combi(idx + 1, cnt);

    }
    public static void per(int cnt){
        //기저조건
        if(cnt == 2){
            nums.add(new Location(num[0], num[1]));
            return;
        }

        for(int i = 0; i < n; i++){
            num[cnt] = i;
            per(cnt + 1);
        }
    } //end of per

    public static void goArea(){
        while(!queue.isEmpty()){
            Location current = queue.poll();

            for(int i = 0; i < 4; i++){
                int nr = current.r + dist[i][0];
                int nc = current.c + dist[i][1];

                if(checked(nr, nc)){
                    if(canGo(current, nr, nc)){
                        queue.offer(new Location(nr, nc));
                        isVisited[nr][nc] = true;
                    }
                }
            }
        }
    }//end of goArea

    public static boolean checked(int nr, int nc){
        return nr >= 0 && nr < n && nc >= 0 && nc < n && !isVisited[nr][nc];
    }//end of checked

    public static boolean canGo(Location current, int nr, int nc){
        int diff = Math.abs(arr[current.r][current.c] - arr[nr][nc]);
        return diff >= u && diff <= d;
    }//end of canGo

}//end of class