import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;
    static int[][] dp;
    static int n;
    
    public static void main(String[] args) throws IOException {

        //모든 경로의 최솟값, 그중 최댓값 구하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());        
            }
        } // 입력 끝

        //1. 초깃값 생성
        init();

        int answer = 0;
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(arr[i][j], Math.min(dp[i-1][j], dp[i][j-1]));
                answer = Math.max(answer, dp[i][j]);
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        if(n == 1){
            System.out.println(arr[0][0]);
        }else{
            System.out.println(answer);
        }
    }

    public static void init(){

        dp[0][0] = arr[0][0];

        //1. 0행 초기화
        for(int i = 1; i < n; i++){
            dp[0][i] = Math.min(arr[0][i-1], arr[0][i]);
            dp[i][0] = Math.min(arr[i-1][0], arr[i][0]);
        }

    }
    
}