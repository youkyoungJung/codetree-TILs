import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        } 

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] == -1) continue;

                if(j + arr[j] >= i){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}