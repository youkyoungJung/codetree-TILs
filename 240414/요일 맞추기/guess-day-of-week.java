import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        String[] date = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        //1    2    3   4   5   6    7    8   9   10   11  12
        int[] monthOfDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int diff = 0;
        diff = ((monthOfDay[m2] + d2) - (monthOfDay[m1] + d1)) + 2;

        if(diff < 0 ){
            diff += 7;
        }
        System.out.println(date[diff%7]);

    }
}