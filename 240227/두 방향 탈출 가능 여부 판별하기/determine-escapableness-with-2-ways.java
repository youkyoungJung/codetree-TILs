import java.util.*;
import java.io.*;

public class Main {

    static int[][] dist = {{1, 0}, {0, 1}};
    static int n;
    static int m;
    static int[][] arr;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0); // i, j
        if(flag){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    public static void dfs(int r, int c){
        if(r == n-1 && c == m-1){
            flag = true;
            return;
        }

        for(int i = 0; i < 2; i++){
            int nr = r + dist[i][0];
            int nc = c + dist[i][1];

            if(checked(nr, nc)){
                dfs(nr, nc);
            }
        }
    }

    public static boolean checked(int nr, int nc){

        if(nr >= 0 && nr < n && nc >= 0 && nc < m && arr[nr][nc] != 0){
            return true;
        }
        return false;
    }
}