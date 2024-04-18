import java.util.*;
import java.io.*;

public class Main {
    static int[][] dist = {{0, 0},{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static int[][] arr;
    static int[][] dir;
    static int n;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        dir = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                dir[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;

        go(r, c, 1, dir[r][c], 1);
        System.out.println(answer);

    }

    static int answer = 0;
    public static void go(int r, int c, int cnt, int d, int depth){
        if(cnt == n){
            answer = Math.max(answer, depth);
            return;
        }

        int nr = r + dist[d][0] * cnt;
        int nc = c + dist[d][1] * cnt;
        if(checked(nr, nc) && arr[r][c] < arr[nr][nc]){
            go(nr, nc, cnt+1, dir[nr][nc], depth+1);
        }else{
            answer = Math.max(answer, depth);
            return;
        }

    }

    public static boolean checked(int nr, int nc){
        return nr >= 0 && nr < n && nc >= 0 && nc < n;
    }

}