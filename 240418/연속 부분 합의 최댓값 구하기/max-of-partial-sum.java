import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
        }
        // System.out.println(Arrays.toString(dp));
        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}