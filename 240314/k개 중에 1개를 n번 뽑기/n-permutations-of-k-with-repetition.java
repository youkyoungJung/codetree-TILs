import java.io.*;
import java.util.*;

public class Main {
    
    static int K, N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        go(0, new int[N]);
        System.out.println(sb);
    }

    public static void go(int idx, int[] arr){
        if(idx == N){
            for(int i : arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= K; i++){
            arr[idx] = i;
            go(idx +1 ,arr); 
        }
    }
}