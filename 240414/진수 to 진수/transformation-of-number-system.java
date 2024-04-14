import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        String n = br.readLine(); //a 진수로 표현된 수
        int[] bit = new int[n.length()];
        for(int i = 0; i < n.length(); i++){
            bit[i] = n.charAt(i)-'0';
        }

        int goToTen = 0;
        // a진수 n을 10 진수로 바꾸기
        for(int i = 0; i < bit.length; i++){
            goToTen = goToTen * a + bit[i];
        }

        // 10 진수를 b로 바꾸기
        while(true){
            if(goToTen < b){
                sb.append(goToTen);
                break;
            }

            sb.append(goToTen % b);
            goToTen /= b;
        }
        System.out.println(sb.reverse());
    }
}