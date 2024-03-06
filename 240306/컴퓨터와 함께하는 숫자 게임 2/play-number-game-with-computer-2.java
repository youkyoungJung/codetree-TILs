import java.util.*;
import java.io.*;

public class Main {
    static int m;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        m = Integer.parseInt(br.readLine()); //13이하의 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = a; i <= b; i++){
            int res = binarySearch(i);
            if(max < res){
                max = res;
            }
            if(min > res){
                min = res;
            }
        }

        System.out.println(min+ " "+ max);


    }

    public static int binarySearch(int target){
        int left = 1;
        int right = m;
        int cnt = 1;

        while(left <= right){
            int mid = (left+right)/2;

            if(mid == target){
                return cnt;
            }else if(mid > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
            cnt++;
        }
        return cnt;
    }
}