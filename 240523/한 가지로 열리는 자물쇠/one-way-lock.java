import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // int total = n*n*n;

        StringTokenizer st = new StringTokenizer(br.readLine());
        //서로 다른 조합
        int[] arr = new int[3];
        for(int i = 0; i < 3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                for(int k = 1; k <= n; k++)
                    if(Math.abs(arr[0]- i) <= 2 || Math.abs(arr[1]- j) <= 2 || Math.abs(arr[2]- k) <= 2)
                        cnt++;

        System.out.println(cnt);
        // System.out.println(total - cnt);
        
    }
}