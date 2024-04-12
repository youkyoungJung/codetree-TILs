import java.util.*;
import java.io.*;

public class Main {

    static int[][][] dist = {{{-1,0},{1,0}},{{0,1},{0,-1}}, {{-1,0},{0,-1}}, {{1,0},{0,-1}},{{-1,0},{0,1}},{{1,0},{0,1}}};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                for(int i = 0; i < dist.length; i++){
                    int nr1 = r + dist[i][0][0];
                    int nc1 = c + dist[i][0][1];
                    int nr2 = r + dist[i][1][0];
                    int nc2 = c + dist[i][1][1];

                    if(checked(nr1, nc1) && checked(nr2, nc2)){
                        answer = Math.max(answer, arr[r][c] + arr[nr1][nc1] + arr[nr2][nc2]);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean checked(int nr, int nc){
        return nr >= 0 && nr <= n-1 && nc >= 0 && nc <= m-1;
    }
}