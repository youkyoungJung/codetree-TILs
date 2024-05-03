import java.util.*;
import java.io.*;

public class Main {
    static int[] bit;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        bit = new int[s.length()];

        for(int i = 0; i < s.length(); i++){
            bit[i] = s.charAt(i) - '0';
        }
        // System.out.println(Arrays.toString(bit));
        int answer = goTen();

       for(int i = 1; i < bit.length; i++){
            int target = bit[i];

            if(target != 0){
                bit[i] = 0;
            }else{
                bit[i] = 1;
            }
            answer = Math.max(answer, goTen());
            bit[i] = target;
        }
        System.out.println(answer);
    }

    //10진수로 바꾸는 함수
    public static int goTen(){
        int num = 0;
        for(int i = 0; i < bit.length; i++){
            num = num * 2 + bit[i];
        }
        return num;
    }
}