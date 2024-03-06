import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int target = Integer.parseInt(st.nextToken());
            sb.append(lowerBound(target)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int lowerBound(int target){
        int left = 1;
        int right = n;
        int minIdx = n + 1;

        while(left <= right){
            int mid = (left + right) /2;
            if(arr[mid] >= target){
                right = mid -1 ;
                minIdx = Math.min(minIdx, mid);
            }else{
                left = mid + 1;
            }

        }

        if(minIdx <= 0 || minIdx > n || arr[minIdx] != target){
            minIdx = -1;
        }
        return minIdx;
    }
}