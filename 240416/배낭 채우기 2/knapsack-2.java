import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //보석의 수
        int m = Integer.parseInt(st.nextToken()); // 가방무게

        int[] dp = new int[m+1];
        int[] weight = new int[n+1];
        int[] value = new int[n+1];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            for(int j = 1; j <= m; j++){ //가방 1g~~m까지
                if(j >= weight[i]){
                    dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
                }
            }
            // System.out.println(Arrays.toString(dp));
        }
        int answer = 0;
        for(int i = 1; i <= m; i++){
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
    
}