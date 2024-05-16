import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] stored = new int[10_001];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            if(c == 'G'){
                stored[num] = 1;
            }else{ //H
                stored[num] = 2;
            }
        }

        int answer = 0;
        for(int i = 1; i < 10_001 - k; i++){
            int sum = 0;
            for(int j = i; j <= i + k; j++){
                sum += stored[j];
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);

    }
}