import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[][] isVisited;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        isVisited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isVisited[0][0] = true;
        dfs(0, 0);

        System.out.println(isVisited[n-1][m-1]?1:0);

    }

    static int[][] dist = {{1, 0}, {0, 1}};
    public static void dfs(int x, int y){

        for(int i = 0; i < dist.length; i++){
            int nx = x + dist[i][0];
            int ny = x + dist[i][1];

            if(checked(nx, ny)){
                isVisited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

    public static boolean checked(int nx, int ny){
        return nx >= 0 && nx < n && ny >= 0 && ny < m  && !isVisited[nx][ny] && arr[nx][ny] == 1;
    }
}