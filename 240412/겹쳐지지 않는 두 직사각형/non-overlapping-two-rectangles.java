import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static int[][] dp;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        dp = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        init();
        //누적합
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                dp[i][j] = dp[i-1][j] - dp[i][j-1] + arr[i][j];
            }
        }

//        System.out.println(Arrays.deepToString(dp));
        int answer = Integer.MIN_VALUE;

        //좌표(nr1, nc1), 좌표(nr2, nc2), 좌표(nr3, nc3), 좌표(nr4, nc4)
        for(int i = 0; i < n*m; i++){
            int nr1 = i / n;
            int nc1 = i % n;

            for(int j = i+1; j < n*m; j++){
                int nr2 = i / n;
                int nc2 = i % n;

                for(int k = 0; k < n*m; k++){
                    int nr3 = k / n;
                    int nc3 = k  % n;

                    for(int l = k+1; l < n*m; l++){
                        int nr4 = l / n;
                        int nc4 = l % n;

                        if(checked(nr2, nc2, nr3, nc3)){
//                            System.out.println("들어와?");
                            int first = dp[nr2][nc2] - dp[nr1][nc1] + arr[nr1][nc1];
                            int second = dp[nr4][nc4] - dp[nr3][nc3] + arr[nr3][nc3];

                            if(answer < first + second){
                                answer = first + second;
//                                System.out.println("nr1: " +nr1 + " nr2: " + nr2 + " nr3: " + nr3 + " nr4: " + nr4);
//                                System.out.println("nc1: " +nc1 + " nc2: " + nc2 + " nc3: " + nc3 + " nc4: " + nc4);
//                                System.out.println("first: " + first);
//                                System.out.println("second: " + second);
                            }
//                            answer = Math.max(answer, first + second);
                        }

                    }
                }

            }
        }
        System.out.println(answer);

    }

    public static boolean checked(int sr, int sc, int nr, int nc){
        return sr <= nr || sc <= nc;

    }

    public static void init(){
        dp[0][0] = arr[0][0];

        for(int i = 1; i < n; i++){
            dp[0][i] = dp[0][i-1] + arr[0][i];
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }
    }
}