import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //막대기 길이

        int[] value = new int[n+1];
        int[] dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            for(int j = i; j >= 1; j--){
                    if(i > j){
                        dp[i] = Math.max(dp[i], dp[i-j] + dp[j]);
                    }else{
                        dp[i] = value[i];
                    }
                    // System.out.println(Arrays.toString(dp));
            }
        }

        System.out.println(dp[n]);

    }
}