import java.io.*;
import java.util.*;

public class Main {
    static int n, s;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = n+1;

        for(int i = 0;i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += arr[j];

                if(sum >= s){
                    answer = Math.min(n, j-i);
                    break;
                }
            }
        }

        System.out.println(answer == n+1 ? -1 : answer);
    }
}