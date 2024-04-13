import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int answer = (int)1e9;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine()); 
        } //end of for

        Arrays.sort(arr);

        int s = 0;
        int e = n-1;

        while(s <= e){
            int target = arr[s];
            // System.out.println("s: " + target);
            // System.out.println("e: " + arr[e]);
            if(m <= Math.abs(arr[e] - target)){
                answer = Math.min(answer, Math.abs(arr[e] - target));
                e--;
            }else{
                s++;
            }
        }
        
        System.out.println(answer);
    }
}