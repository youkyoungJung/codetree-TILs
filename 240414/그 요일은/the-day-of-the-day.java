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
//        System.out.println("findNum: " + findNum);

        d1 += findNum;

        int answer = 0;
        int start = 0;
        int diff = totalDays(m2, d2) - totalDays(m1, d1);
//        for (int i = 1; i <= diff; i++) {
//            start = (start + 1) % 7;
//            if (start == findNum) {
//                answer++;
//            }
//        }
        System.out.println(diff/7+1);

    }

    public static int getNum(String day){
        int target = 0;
        for (int i = 1; i < days.length; i++) {
            if (day.equals(days[i])) {
                target = i;
                break;
            }
        }
        return target;
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