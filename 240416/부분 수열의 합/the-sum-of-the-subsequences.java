import java.util.*;
import java.io.*;

public class Main {

    static int[] dp;
    static int m;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        dp = new int[m+1];
        init();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = false;
        for(int i = 1; i <= m; i++){
            for(int j = 0; j < n; j++){
                if(i >= nums[j]){
                    if(dp[i - nums[j]] == -1){
                        continue;
                    }
                    dp[i] = dp[i - nums[j]] + 1;
                }
            }
            if(dp[m] == 0){
                flag = true;
            }
        }

        if(!flag){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }

    }

    public static void init(){

        for(int i = 0; i < m+1; i++){
            dp[i] = 0;
        }
        dp[0] = 1;

    }

}