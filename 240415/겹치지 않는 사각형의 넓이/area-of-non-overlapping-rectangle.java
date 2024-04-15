import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[][] arr = new boolean[2001][2001];
        int answer = 0;

        int ax1 = Integer.parseInt(st.nextToken())+1000;
        int ay1 = Integer.parseInt(st.nextToken())+1000;
        int ax2 = Integer.parseInt(st.nextToken())+1000;
        int ay2 = Integer.parseInt(st.nextToken())+1000;

        for(int i = ax1; i < ax2; i++){
            for(int j = ay1; j < ay2; j++){
                arr[i][j] = true;
            }
        }

        st = new StringTokenizer(br.readLine());
        int bx1 = Integer.parseInt(st.nextToken())+1000;
        int by1 = Integer.parseInt(st.nextToken())+1000;
        int bx2 = Integer.parseInt(st.nextToken())+1000;
        int by2 = Integer.parseInt(st.nextToken())+1000;

        for(int i = bx1; i < bx2; i++){
            for(int j = by1; j < by2; j++){
                arr[i][j] = true;
            }
        }

        st = new StringTokenizer(br.readLine());
        int mx1 = Integer.parseInt(st.nextToken())+1000;
        int my1 = Integer.parseInt(st.nextToken())+1000;
        int mx2 = Integer.parseInt(st.nextToken())+1000;
        int my2 = Integer.parseInt(st.nextToken())+1000;

        for(int i = mx1; i < mx2; i++){
            for(int j = my1; j < my2; j++){
                arr[i][j] = false;
            }
        }

        // System.out.println(Arrays.deepToString(arr));
        for(int i = 0; i < 2000; i++){
            for(int j = 0; j < 2000; j++){
                if(arr[i][j]) answer++;
            }
        }
        System.out.println(answer);


    }
}