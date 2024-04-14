import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] bit = new int[s.length()];

        for(int i = 0; i < s.length(); i++){
            bit[i] = s.charAt(i) - '0';
        }
        
        int goToTen = 0;
        //1. 10진수로 바꾸기
        for(int i = 0; i < bit.length; i++){
            goToTen = goToTen * 2 + bit[i];
        }

        goToTen *= 17;

        //2. 2진수로 다시 전환
        while(goToTen > 0){
            sb.append(goToTen%2);

            goToTen /= 2;
        }

        System.out.println(sb.reverse());
    }
}