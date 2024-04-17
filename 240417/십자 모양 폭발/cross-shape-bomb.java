import java.util.*;
import java.io.*;

public class Main {
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//상하좌우
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;

        //1. 터지기
        bomb(r, c);
        //2. 아래로 내려오기
        down();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static void bomb(int r, int c){
        // System.out.println("r: " + r + " c: " + c);
        int target = arr[r][c];

        arr[r][c] = 0;
        for(int t = 1; t < target; t++){
            for(int i = 0; i < 4; i++){
                int nr = r + dist[i][0] * t;
                int nc = c + dist[i][1] * t;

                if(checked(nr, nc)){
                    // System.out.println("nr: " + nr + " nc: " + nc);
                    arr[nr][nc] = 0;
                }
            }
        }

    }

    public static boolean checked(int nr, int nc){
        return nr >= 0 && nr < n && nc >= 0 && nc < n;
    }

    public static void down(){
        for(int j = 0; j < n; j++){
            int[] temp = new int[n];
            int idx = n-1;

            for(int i = n-1; i >= 0; i--){
                if(arr[i][j]!=0){
                    temp[idx--] = arr[i][j];
                }
            }

            for(int k = 0; k < n; k++){
                arr[k][j] = temp[k];
            }

        }
    }


}