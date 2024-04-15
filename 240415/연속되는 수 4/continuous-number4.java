import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int cnt = 0;
        int answer = 0;

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(i == 0 || arr[i-1] < arr[i]){
                cnt++;
                answer = Math.max(answer, cnt);
            }else{
                cnt = 1;
            }
        }

        System.out.println(answer);
    }
}