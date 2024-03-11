import java.io.*;
import java.util.*;

public class Main {
    static long s;
    static ArrayList<Long> list = new ArrayList();
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Long.parseLong(br.readLine());
        long start = 0, end = 2000000000;
        long answer = 0;
        while(start <= end){
            long mid = (start + end) / 2;
            if(mid *(mid+1) /2 <= s){
                answer = Math.max(mid, answer);
                start = mid+1;
            } else{
                end = mid-1;
            }
        }

        System.out.println(answer);
    }
}