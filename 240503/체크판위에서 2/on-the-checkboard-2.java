import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = st.nextToken().charAt(0);
            }
        }

        int cnt = 0;
        // System.out.println(Arrays.deepToString(arr));
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                for(int k = i+1; k < n-1; k++){
                    for(int l = j+1; l < m-1; l++){
                        if(arr[0][0] != arr[i][j] &&
                            arr[i][j] != arr[j][k] &&
                            arr[j][k] != arr[n-1][m-1]){
                            cnt++;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);

    }//end of main

}