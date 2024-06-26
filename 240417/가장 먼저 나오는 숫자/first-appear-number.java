import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int target = Integer.parseInt(st.nextToken());
            int lo = binarySearch(target);

            if(lo <= n && arr[lo] == target){
                sb.append(lo).append("\n");
            }else{
                sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int binarySearch(int target){
        int left = 1;
        int right = n;
        int minIdx = n+1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] >= target){
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }else{
                left = mid + 1;
            }
        }

        return minIdx;
    }
}