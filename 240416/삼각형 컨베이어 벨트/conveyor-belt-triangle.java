import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t =  Integer.parseInt(st.nextToken());

        int[][] arr = new int[3][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(t-- > 0){
            int temp = arr[0][n-1];
            int temp2 = arr[1][n-1];
            int temp3 = arr[2][n-1];
            for(int i = n-1; i >= 1; i--){
                arr[0][i] = arr[0][i-1];
            }
            for(int i = n-1; i >= 1; i--){
                arr[1][i] = arr[1][i-1];
            }
            for(int i = n-1; i >= 1; i--){
                arr[2][i] = arr[2][i-1];
            }
            arr[1][0] = temp;
            arr[2][0] = temp2;
            arr[0][0] = temp3;

        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j  < n; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}