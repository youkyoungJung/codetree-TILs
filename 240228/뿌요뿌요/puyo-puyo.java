import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int res = 0;
    static boolean[][] isVisited;
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //상, 하, 좌, 우

    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        isVisited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!isVisited[i][j]){
                    isVisited[i][j] = true;
                    dfs(i, j, arr[i][j]);
                    if(cnt >= 4){
                        answer++;
                    }
                    res = Math.max(res, cnt);
                    cnt = 1;

                }
            }
        }
        System.out.println(answer + " " + res);

    }


    public static void dfs(int r, int c, int key){

        for(int i = 0; i < 4; i++){
            int nr = r + dist[i][0];
            int nc = c + dist[i][1];

            if(checked(nr, nc, key)){
                cnt++;
                isVisited[nr][nc] = true;
                dfs(nr, nc, key) ;
            }
        }
    }

    public static boolean checked(int r, int c, int key){
        return r >= 0 && r < n && c >= 0 && c < n && !isVisited[r][c] && arr[r][c] == key;
    }
}