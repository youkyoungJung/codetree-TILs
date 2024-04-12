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
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + arr[i][j] - dp[i-1][j-1];
            }
        }

//        System.out.println(Arrays.deepToString(dp));
        int answer = Integer.MIN_VALUE;

        int length = n*m;
        //좌표(nr1, nc1), 좌표(nr2, nc2), 좌표(nr3, nc3), 좌표(nr4, nc4)
        for(int i = 0; i < length; i++){
            int nr1 = i / n;
            int nc1 = i % n;

            for(int j = i; j < length; j++){
                int nr2 = j / n;
                int nc2 = j % n;

                //여기서 check (nr2, nc2) 가 더 커야함.
                if(checked1(nc1, nc2)) {

                    for (int k = 0; k < length; k++) {
                        int nr3 = k / n;
                        int nc3 = k % n;

                        for (int l = k; l < length; l++) {
                            int nr4 = l / n;
                            int nc4 = l % n;

                            if(checked1(nc3, nc4)) {

                                //check 함수 안에 사각형 2 번갈아서 검사하기
                                if (checked(nr1, nc1, nr2, nc2, nr3, nc3, nr4, nc4)) {
//                            System.out.println("들어와?");
                                    int first = dp[nr2][nc2] - dp[nr1][nc1] + arr[nr1][nc1];
                                    int second = dp[nr4][nc4] - dp[nr3][nc3] + arr[nr3][nc3];

                                    if (answer < first + second) {
                                        answer = first + second;
//                                        System.out.println("nr1: " + nr1 + " nr2: " + nr2 + " nr3: " + nr3 + " nr4: " + nr4);
//                                        System.out.println("nc1: " + nc1 + " nc2: " + nc2 + " nc3: " + nc3 + " nc4: " + nc4);
//                                        System.out.println("first: " + first);
//                                        System.out.println("second: " + second);
                                    }
//                            answer = Math.max(answer, first + second);
                                }
                            }

                        }
                    }
                }

            }
        }
        System.out.println(answer);

    }

    public static boolean checked1(int nc1, int nc2){
        return nc1 <= nc2;
    }

    public static boolean checked(int sr1, int sc1, int sr2, int sc2, int nr3, int nc3, int nr4, int nc4){

        // 사각형 네점1
//        int[] i1 = {sr1, sc1};
//        int[] i2 = {sr2, sc1};
//        int[] i3 = {sr1, sc2};
//        int[] i4 = {sr2, sc2};

        // 사각형 네점2
        int[] j1 = {nr3, nc3};
        int[] j2 = {nr4, nc3};
        int[] j3 = {nr3, nc4};
        int[] j4 = {nr4, nc4};
        int[][] points = {
                {nr3, nc3},
                {nr4, nc3},
                {nr3, nc4},
                {nr4, nc4}
        };


        for (int i = 0; i < 4; i++) {
            if (sr1 <= points[i][0] && points[i][0] <= sr2 && sc1 <= points[i][1] && points[i][1] <= sc2){
                return false;
            }
        }
        return true;

        // 사각형1 에서 사각형2 비교

        // 사각형2 에서 사각형1 비교

//        return true;

    }

    public static void init(){
        dp[0][0] = arr[0][0];

        for(int i = 1; i < n; i++){
            dp[0][i] = dp[0][i-1] + arr[0][i];
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }
    }
}