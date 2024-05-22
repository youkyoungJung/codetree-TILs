import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        //서로 다른 조합
        int[] arr = new int[3];
        int a = 1;
        for(int i = 0; i < 3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            a *= arr[i];
        }

        int total = 6*6*6;
        System.out.println(total - a);
        
    }
}