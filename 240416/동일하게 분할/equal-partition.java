import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n+1];
        int sum = 0;

        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());   
            sum += arr[i];
        }
        boolean[][] dp = new boolean[n+1][sum+1];
        dp[0][0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= sum; j++){
                if(j >= arr[i] && dp[i - 1][j - arr[i]]){
                    dp[i][j] = true;
                }

                if(dp[i - 1][j]){
                    dp[i][j] = true;
                }
            }
        }

        for(int i = 0; i <= sum; i++){
            if(dp[n][i]){
                // System.out.println("i: "+ i);
                if(i == sum/2){
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");

    }
}