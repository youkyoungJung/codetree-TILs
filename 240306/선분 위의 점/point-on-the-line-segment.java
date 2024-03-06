import java.io.*;
import java.util.*;

public class Main {
    static Long[] arr;
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new Long[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int min = lowerBound(start);
            int max = upperBound(end);
            sb.append(max - min).append("\n");
        }
        System.out.println(sb.toString());

    }

    public static int lowerBound(int target){
        int left = 1;
        int right = n;
        int minIdx = n+1;

        while(left <= right){
            long mid = (long) ((left + right) / 2);

            if(arr[(int) mid] >= target){
                right = (int) (mid - 1);
                minIdx = (int) Math.min(minIdx, mid);
            }else{
                left = (int) (mid + 1);
            }
        }
        return minIdx;
    }

    public static int upperBound(int target){
        int left = 1;
        int right = n;
        int minIdx = n+1;

        while(left <= right){
            long mid = (long) ((left + right) / 2);            
            if(arr[(int)mid] > target){
                right = (int) (mid - 1);
                minIdx = (int) Math.min(minIdx, mid);
            }
            else{
                left = (int) (mid + 1);
            }

        }
        return minIdx;

    }
}