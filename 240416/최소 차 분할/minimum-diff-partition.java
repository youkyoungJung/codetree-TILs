import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];

        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        boolean[] dp = new boolean[sum+1];

        for(int i = 1; i <= n; i++){ //A 그룹
            for(int j = n; j >= 1; j--){
                if(j < arr[i]){
                    dp[j] = true;
                }
            }
        } 

        int answer = Integer.MAX_VALUE;

        for(int i = 0; i <= sum; i++){
            if(dp[i]){
                answer = Math.min(answer, Math.abs(sum-i-i));
            }
        }
        System.out.println(answer);
    }
}