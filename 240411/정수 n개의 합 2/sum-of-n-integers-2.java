import java.io.*;
import java.util.*;

public class Main {
    static int n, k, max;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int x = Integer.parseInt(st.nextToken());
            arr[i] = arr[i-1] + x;
        }

        for(int i = k; i <= n-k; i++){
            max = Math.max(max, arr[i]-arr[i-k]);
        }
        System.out.println(max);
    }
}