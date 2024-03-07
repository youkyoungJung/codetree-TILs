import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int left = 1;
        int right = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }

        int answer = Integer.MIN_VALUE;
        while(left <= right){
            int mid = (left + right) / 2;

            if(isPossible(mid)){ //결정에 대한 문제가 Yes
                left = mid + 1;
                answer = Math.max(answer, mid);
            }else{
                right = mid - 1;
            }

        }

        if(answer == Integer.MIN_VALUE){
            answer = 0;
        }
        System.out.println(answer);

    }

    public static boolean isPossible(int target){
        int cnt = 0;

        for(int i = 0; i < n; i++){
            cnt += (arr[i]/target);
        }

        return cnt >= m;
    }
}