import java.util.*;
import java.io.*;

public class Main {
    static long m;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Long.parseLong(br.readLine()); //13이하의 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for(long i = a; i <= b; i++){
            long res = binarySearch(i);
            if(max < res){
                max = res;
            }
            if(min > res){
                min = res;
            }
        }

        System.out.println(min+ " "+ max);


    }

    public static long binarySearch(long target){
        long left = 1;
        long right = m;
        long cnt = 1;

        while(left <= right){
            long mid = (left+right)/2;

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