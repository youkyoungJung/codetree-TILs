import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] bit = new int[s.length()];

        for(int i = 0; i < s.length(); i++){
            bit[i] = s.charAt(i)-'0';
        }

//        System.out.println(Arrays.toString(bit));
        int answer = 0;

        for(int i = 0; i < bit.length; i++){
            answer = answer * 2 + bit[i];
        }

        System.out.println(answer);

    }
}