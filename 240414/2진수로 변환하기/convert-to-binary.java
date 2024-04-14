import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        if(n == 0){
            System.out.println(0);
            return;
        }

        while(n > 0){
            int div = n % 2;
            sb.append(div);
            n /= 2;
        }
        System.out.println(sb.reverse());
    }
}