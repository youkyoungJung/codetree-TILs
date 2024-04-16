import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //보석정보n 개
        int m = Integer.parseInt(st.nextToken()); //무게 m 을 넘지 않아야함

        int[][] dp = new int[n+1][m+1];
        int[] weigth = new int[n+1];
        int[] value = new int[m+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); //보석의 무게
            int v = Integer.parseInt(st.nextToken()); //보석의 가치

            weigth[i] = w;
            value[i] = v;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(j >= weigth[i]){
                    dp[i][j] = Math.max(dp[i-1][j - weigth[i]] + value[i], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int answer = 0;
        for(int i = 0; i <= m; i++){
            answer = Math.max(answer, dp[n][i]);
        }

        System.out.println(answer);
    }
}