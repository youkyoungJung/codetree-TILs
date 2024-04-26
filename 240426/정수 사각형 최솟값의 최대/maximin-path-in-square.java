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
        // System.out.println(Arrays.deepToString(dp));

        ArrayList<Integer> res = new ArrayList<>();
        // res.add(arr[0][0]);
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] =  Math.max(Math.min(dp[i-1][j], arr[i][j]), Math.min(dp[i][j-1], arr[i][j]));
            }
        }
        
        // System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[n-1][n-1]);
        
    }

    public static void init(){

        dp[0][0] = arr[0][0];

        //1. 0행 초기화
        for(int i = 1; i < n; i++){
            dp[0][i] = Math.min(dp[0][i-1], arr[0][i]);
            dp[i][0] = Math.min(dp[i-1][0], arr[i][0]);
        }

    }
    
}