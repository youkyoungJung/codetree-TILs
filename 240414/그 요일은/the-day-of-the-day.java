/**
 정답 코드
*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] days = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        st = new StringTokenizer(br.readLine(), " ");
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        int sum1 = 0, sum2 = 0;
        for (int i = 1; i < m1; i++) {
            sum1 += days[i];
        }
        for (int i = 1; i < m2; i++) {
            sum2 += days[i];
        }
        sum1 += d1;
        sum2 += d2;

        int diff = sum2 - sum1;
        int start = 0, target = 0, answer = 0;

        for (int i = 1; i < week.length; i++) {
            if (str.equals(week[i])) {
                target = i;
                break;
            }
        }

        for (int i = 1; i <= diff; i++) {
            start = (start + 1) % 7;
            if (start == target) {
                answer++;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}