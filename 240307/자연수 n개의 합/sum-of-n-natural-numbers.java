import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

public class Main {
    static int s;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());

        System.out.println(parametricSearch(s));
    }

    public static int parametricSearch(int s){
        int left = 1;
        int right = s + 1;
        int maxIdx = 0;

        while(left <= right){
            int mid = (left + right) / 2;

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