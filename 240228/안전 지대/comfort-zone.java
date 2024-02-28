import java.util.*;
import java.io.*;

public class Main {

    static boolean[][] isVisited;
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //상, 하, 좌, 우
    static int n;
    static int m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        int k = -1;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(k < arr[i][j]){
                    k = arr[i][j];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int answer = 0;
        for(int s = 1; s <= k; s++){
            int cnt = 0;
            isVisited = new boolean[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(!isVisited[i][j] && arr[i][j] > s){
                        isVisited[i][j] = true;
                        dfs(i, j, s);
                        cnt++;
                    }
                }
            }

            if(max < cnt){
                max = cnt;
                answer = s;
            }
//            System.out.println("cnt:"  + cnt);
        }

        System.out.println(answer + " " + max);

    }

    public static void dfs(int r, int c, int k){

        for(int i = 0; i < 4; i++){
            int nr = r + dist[i][0];
            int nc = c + dist[i][1];

            if(checked(nr, nc, k)){
                isVisited[nr][nc] = true;
                dfs(nr, nc, k);
            }
        }

    }

    public static boolean checked(int r, int c, int k){
        return r >= 0 && r < n && c >= 0 && c < m && !isVisited[r][c] && arr[r][c] > k;
    }

}