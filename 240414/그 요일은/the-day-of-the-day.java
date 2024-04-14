import java.util.*;
import java.io.*;

public class Main {
    static String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    static int[] monthsOfDay = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        String day = br.readLine();
        int findNum = getNum(day);

        d1 += findNum;

        int diff = totalDays(m2, d2) - totalDays(m1, d1);
        // System.out.println(diff);

        System.out.println(diff/7 + 1);

    }

    public static int getNum(String day){
        for(int i = 0; i < 7; i++){
            if(days[i] == day){
                return i;
            }
        }
        return -1;
    }

    public static int totalDays(int month, int day){
        int totalDay = 0;

        for(int i = 1; i < month; i++){
            totalDay += monthsOfDay[i];
        }

        totalDay += day;

        return totalDay;
    }
}