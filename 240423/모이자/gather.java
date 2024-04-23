import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int target = arr[i];
            int res = 0;

            for(int j = 0; j < n; j++){
                if(j != i){
                    res += (Math.abs(i - j)*arr[j]);
                }
            }

            answer = Math.min(answer, res);
        }

        System.out.println(answer);
    }
}