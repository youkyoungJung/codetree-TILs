import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n;
    static StringBuilder sb = new StringBuilder();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int min = lowerBound(start);
            int max = upperBound(end);
            sb.append(max - min + answer).append("\n");
            answer = 0;
        }
        System.out.println(sb.toString());

    }

    public static int lowerBound(int target){
        int left = 1;
        int right = n;
        int minIdx = n+1;

        while(left <= right){
            int  mid = (left + right) / 2;

            if(arr[mid] >= target){
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }else{
                left = mid + 1;
            }
        }
        if(minIdx >= 1 && minIdx <= n  && arr[minIdx] < target){
            answer--;
        }
        return minIdx;
    }

    public static int upperBound(int target){
        int left = 1;
        int right = n;
        int minIdx = n+1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] > target){
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }
            else{
                left = mid + 1;
            }

        }
        if(minIdx >= 1 && minIdx <= n  && arr[minIdx] == target){
            answer++;
        }
        return minIdx;

    }
}