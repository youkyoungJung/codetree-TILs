import java.io.*;
import java.util.*;


public class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
        }
        int left = 1, right = 100001;
        int answer = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(div(mid) >= m ){
                left = mid +1;
                answer = Math.max(mid, answer);
            } else {
                right = mid -1;
            }
        }

        System.out.println(answer);
    }

    public static int div(int x){
        int cnt = 0;
        for(int i : arr){
            cnt += i / x;
        }
        return cnt;
    }
}