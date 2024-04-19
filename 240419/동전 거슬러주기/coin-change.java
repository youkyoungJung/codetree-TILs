import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] dp = new int[m+1];
        Arrays.fill(dp, 10_001);
        dp[0] = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int target = 1; target <= m; target++){
            for(int i = 0; i < n; i++){
                if(target >= arr[i]){
                    dp[target] = Math.min(dp[target], dp[target - arr[i]]+1);
                }
            }
        }
        if(dp[m] == 10_001){
            System.out.println(-1);
        }else{
            System.out.println(dp[m]);
        }
    }
}