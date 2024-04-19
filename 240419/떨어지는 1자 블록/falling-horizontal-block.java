import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;
    static int n;
    static int m;
    static int k;
    static int currentR = 0;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken())-1; //열

        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //1. 행 구하기 열부터(k) 가장 위인 곳 체크(길이도 같이 체크하면서)
        while(true){
            boolean exist = simulate();
            if(!exist) break; //행이 더 이상 움직일 필요가 없으면.
            currentR++;
        }

        //2. 된다면 블럭 채움. 안된다면 위로 올라가기
        for(int i = k; i < k + m; i++){
            arr[currentR-1][i] = 1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    //행구하기 
    public static boolean simulate(){

        //만날 때를 찾아야함.    
        for(int j = 0; j < m; j++){
            if(checked(j+k) && arr[currentR][j+k] == 1){ //범위를 벗어 나지 않고, 만나는점이 1이면 return;
                return false;
            }
        }
        // currentR = currentR+1;
        return true;
    }

    public static boolean checked(int column){
        return column >= 0 && column < n; 
    }
    
}