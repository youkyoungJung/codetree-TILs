import java.util.*;
import java.io.*;

public class Main {
    static class Pair{
        int r;
        int c;
        public Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] arr;
    boolean check = false;
    static int nowR;
    static int nowC;
    static int n;
    // static Pair maxPair;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        nowR = Integer.parseInt(st.nextToken())-1; //시작점
        nowC = Integer.parseInt(st.nextToken())-1;

        arr = new int[n][n];
        // maxPair = new Pair(r, c);

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[nowR][nowC]);

        while(true){
            boolean exist = simulate();
            if(!exist) break;

            answer.add(arr[nowR][nowC]);
        }
        for(int i = 0; i < answer.size(); i++){
            sb.append(answer.get(i)).append(" ");
        }
        System.out.println(sb);

    }
    public static boolean simulate(){ //갈 수 있는지 확인, 어디까지 갔나.

        for(int i = 0; i < 4; i++){
            int nr = nowR + dist[i][0];
            int nc = nowC + dist[i][1];

            if(checked(nr, nc) && arr[nr][nc] > arr[nowR][nowC]){
                nowR = nr;
                nowC = nc;
                return true;
            }
        }
        return false;
    }

    public static boolean checked(int nr, int nc){
        return nr >= 0 && nr < n && nc >= 0 && nc < n;
    }
}