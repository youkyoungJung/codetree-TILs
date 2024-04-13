import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double answer = Integer.MIN_VALUE;

        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        int[] right = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // Arrays.sort(arr);

        for(int i = 1; i <= n; i++){
            dp[i] = dp[i-1] + arr[i];
        }

        int temp = Integer.MAX_VALUE;
        for(int i = n; i >= 1; i--){
            right[i] = Math.min(temp, arr[i]);
            temp = right[i];
        }

        // System.out.println(Arrays.toString(dp));
        for(int i = 1; i <= n-2; i++){
            double avg = (double)((dp[n] - dp[i] - right[i+1]) / (n-i-1));
            answer = Math.max(answer, avg);
        }

        System.out.printf("%.2f", answer);
    }
}