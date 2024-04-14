import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int answer = 0;

        //                      1   2  3    4   5  6   7   8   9  10  11  12
        int[] dayOfMonth = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        while(true){

            if(m1 == m2 && d1 == d2){
                break;
            }

            answer++;
            d1++;

            if(dayOfMonth[m2] < d1){
                m1++;
                d1 = 1;
            }

        }

        System.out.println(answer);
    }
}