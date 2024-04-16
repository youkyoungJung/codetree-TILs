import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int q;
    static int[][] arr;
    // static int r;
    // static int dir;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(q-->0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int startDir = st.nextToken().charAt(0) == 'L' ? 0 : 1;

            //1.wind shift
            windShift(r, startDir);
            //2.방향 바꾸기
            startDir = changeDir(startDir);
            //3.위탐색 (맞는가 확인하고)
            for (int i = r, dir = startDir; i >= 1; i--) {
                if (checked(i - 1, i)) {
                    windShift(i - 1, dir);
                    dir = changeDir(dir);
                } else {
                    break;
                }
            }

            //4.아래탐색
            for (int i = r, dir = startDir; i < n - 1; i++) {
                if (checked(i + 1, i)) {
                    windShift(i + 1, dir);
                    dir = changeDir(dir);
                } else {
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void windShift(int r, int dir){
        // System.out.println(dir);
        if(dir == 0){ // L
            int temp = arr[r][m-1];
            // System.out.println(temp);


            for(int i = m-1; i >=1; i--){
                arr[r][i] = arr[r][i-1];
            }
            arr[r][0] = temp;

        }else{ // 1
            int temp = arr[r][0];

            for(int i = 0; i < m-1; i++){
                arr[r][i] = arr[r][i+1];
            }
            arr[r][m-1] = temp;
        }
    }

    public static int changeDir(int dir){
        if(dir == 0)
            return 1;
        return 0;
    }

    public static boolean checked(int target, int current){
        for(int i = 0; i < m; i++){
            if(arr[target][i] == arr[current][i]) return true; // 같은 점이 있다면
        }
        return false;
    }
}