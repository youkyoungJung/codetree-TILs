import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] arr = new int[2][n];
        for(int i = 0; i < 2; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int time = 0; time < t; time++){
            int temp1 = arr[0][n-1];
            int temp2 = arr[1][n-1];
            for(int i = n-1; i >= 1; i--){
                arr[0][i] = arr[0][i-1];
            }
            arr[0][0] = temp2;
            for(int i = n-1; i >= 1; i--){
                arr[1][i] = arr[1][i-1];
            }
            arr[1][0] = temp1; 
        }  
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 2; i++){
            for(int j = 0; j  < n; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}