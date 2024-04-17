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
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++){
            int target = Integer.parseInt(br.readLine());
            int cnt = upperBound(target) - lowerBound(target);
            System.out.println(cnt);
        }

    }

    public static int upperBound(int target){
        int left = 0;
        int right = n-1;
        int minIdx = n;

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] > target){
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }else{
                left = mid + 1;
            }
        }
        return minIdx;
    }

    public static int lowerBound(int target){
        int left = 0;
        int right = n-1;
        int minIdx = n;

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