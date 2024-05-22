import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] bucket = new int[10001];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int candy = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken()) + 100;

            bucket[num] += candy;
        }

        int answer = 0;
        for(int c = 100; c <= 200; c++){
            int sum = 0;
            if(k <= c){
                for(int i = c - k; i <= c + k; i++){
                    sum += bucket[i];
                }
            }
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}