import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 16;

        while(left <= right){
            int mid = (left + right) / 2;

            int counting = countNum(left, mid);
//            System.out.println("counting: " + counting);
            if(counting == target){
                System.out.println(mid);
                return;
            }else if(counting > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
    }

    public static int countNum(int left, int mid){
        int cnt = 0;

        for(int i = 1; i <= mid; i++){
            if(i % 3 != 0 && i % 5 != 0){
                cnt++;
            }
        }
        return cnt;
    }
}