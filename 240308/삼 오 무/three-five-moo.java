import java.util.*;
import java.io.*;

public class Main {
    static int target;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine());

        long left = 0;
        long right = Integer.MAX_VALUE;

        while(left+1 < right){
            long mid = (left + right) / 2;

            if(checked(mid)){
                right = mid;
            }else{
                left = mid;
            }
        }

        System.out.println(right);
    }

    public static boolean checked(long mid){
        long res = mid - mid / 3 - mid / 5 + mid / 15;
        return res >= target;
    }
}
//968460, 1815862
//993859, 1863484
//955230 ,1791056
//936231426, 1755433922