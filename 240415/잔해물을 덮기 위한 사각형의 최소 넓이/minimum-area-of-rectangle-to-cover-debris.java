import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] arr = new boolean[2001][2001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken())+1000;
        int y1 = Integer.parseInt(st.nextToken())+1000;
        int x2 = Integer.parseInt(st.nextToken())+1000;
        int y2 = Integer.parseInt(st.nextToken())+1000;

        for(int i = x1; i < x2; i++){
            for(int j = y1; j < y2; j++){
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
                arr[i][j] = false;
            }
        }

        int maxX = 0;
        int maxY = 0;
        int minX = 20001;
        int minY = 20001;

        for(int i = 0; i < 2001; i++){
            for(int j = 0; j < 2001; j++){
                if(arr[i][j]){
                    maxX = Math.max(maxX, i - 1000 + 1);
                    maxY = Math.max(maxY, j - 1000 + 1);
                    minX = Math.min(minX, i - 1000);
                    minY = Math.min(minY, j - 1000);
                }
            }
        }

        // System.out.println("maxX: " + maxX);
        // System.out.println("maxY: " + maxY);
        // System.out.println("minX: " + minX);
        // System.out.println("minY: " + minY);

        
        System.out.println((maxX - minX) * (maxY - minY));
    }
}