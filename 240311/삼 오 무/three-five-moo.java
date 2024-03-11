import java.io.*;
import java.util.*;

public class Main {

    static long N;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        long left = 0, right = Long.MAX_VALUE, answer = Long.MAX_VALUE;
        while(left <= right){
            long mid = (left + right) /2;
            if(tf(mid) >= N){
                right = mid -1;
                answer = Math.min(answer, mid);
            } else{
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static long tf(long x){
        long cnt = x;
        cnt -= (x/3);
        cnt -= (x/5);
        cnt += (x/15);
        return cnt;
    }
}