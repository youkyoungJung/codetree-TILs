import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(binarySearch(n)).append("\n");
        }
        System.out.println(sb.toString());

    }

    public static int binarySearch(int target){
        int left = 1;
        int right = n;

        while(left <= right){
            int mid = (left + right) / 2;

            if(target == arr[mid]){
                return mid;

            }else if(target < arr[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}