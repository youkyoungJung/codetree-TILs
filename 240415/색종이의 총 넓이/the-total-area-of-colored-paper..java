import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[300][300];
        for(int k = 0; k < n; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())+100;
            int y = Integer.parseInt(st.nextToken())+100;

            for(int i = x; i < x+8; i++){
                for(int j = y; j < y+8; j++){
                    arr[i][j] = true;
                }
            }

        }

        int answer = 0;
        for(int i = 0; i < 300; i++){
            for(int j = 0; j < 300; j++){
                if(arr[i][j]) answer++;
            }
        }

        System.out.println(answer);
    }
}