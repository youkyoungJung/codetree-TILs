import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int n;
    static int m;
    static int q;
    static int r1, c1, r2, c2;
    static int[][] tempArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m+1];
        tempArr = new int[n+1][m+1];

        for(int i = 1; i < n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < m+1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //(r1, c1), (r2, c2)
        //바람 횟수만큼 돌리기
        while(q-- > 0){
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken());
            c1 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());
            shift(r1, c1, r2, c2);
            simulation(r1, r2, c1, c2);
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j <m+1; j++){
                if(i >= r1 && i <= r2 && j >= c1 && j <= c2){
                    arr[i][j] = tempArr[i][j];
                }
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        // System.out.println(Arrays.deepToString(arr));
        System.out.println(sb.toString());

    }//end of main

    //1. 경계값에 따라 시계방향으로 돌리기
    public static void shift(int r1, int c1, int r2, int c2){

        int temp = arr[r1][c1];

        for(int i = r1; i < r2; i++){
            arr[i][c1] = arr[i+1][c1];
        }
        for(int i = c1; i < c2; i++){
            arr[r2][i] = arr[r2][i+1];
        }
        for(int i = r2; i > r1; i--){
            arr[i][c2] = arr[i-1][c2];
        }
        for(int i = c2; i > c1; i--){
            arr[r1][i] = arr[r1][i-1];
        }

        arr[r1][c1+1] = temp;


    }

    //2. 주변 값의 평균내고 바꾸기.
    public static void averageChange(int target, int r, int c){
        int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //상하좌우
        int sum = target;

        int cnt = 1;
        for(int i = 0; i < dist.length; i++){
            int nx = r + dist[i][0];
            int ny = c + dist[i][1];

            if(nx < 1 || nx > n || ny < 1 || ny > m){
                continue;
            }
            sum += arr[nx][ny];
            cnt++;
        }

        int average = sum / cnt;
        tempArr[r][c] = average;

    }

    public static void simulation(int r1, int r2, int c1, int c2){
        for(int i = r1; i <= r2; i++){
            for(int j = c1; j <= c2; j++){
                int target = arr[i][j];
                averageChange(target, i, j);
            }
        }
    }

}//end of class