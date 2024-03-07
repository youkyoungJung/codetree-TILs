import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        int left = 1;
        int right = Integer.MAX_VALUE;
        int midIdx = Integer.MAX_VALUE;

        while(left <= right){
            int mid = (left + right) / 2;

            int counting = countNum(mid);
            if(counting >= target){
                midIdx = Math.min(midIdx, right);
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(midIdx);
    }

    public static int countNum(int target){
        return target - (target / 3 + target / 5 - target / 15) ;
    }
}
//968460, 1815862

//993859, 1863484