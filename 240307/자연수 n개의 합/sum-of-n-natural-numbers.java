import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

public class Main {
    static long s;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Long.parseLong(br.readLine());

        System.out.println(parametricSearch(s));
    }

    public static long parametricSearch(long s){
        long left = 1;
        long right = (long) (Math.sqrt(s * 2) + 1);
        long maxIdx = 0;

        while(left <= right){
            long mid = (left + right) / 2;

            if(mid*(mid + 1) / 2 <= s){
                left = mid + 1;
                maxIdx = Math.max(maxIdx, mid);
            }else{
                right = mid - 1;
            }
        }
        return maxIdx;
    }
}
//1407207346