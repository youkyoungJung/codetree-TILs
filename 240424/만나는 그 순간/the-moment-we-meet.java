import java.util.*;
import java.io.*;

public class Main {
    static int[] timeA = new int[2_000_000];
    static int[] timeB = new int[2_000_000];
    static int index = 1;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            char dir = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            go(dir, num);
        }

        index = 1;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            char dir = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            go2(dir, num);
           
        }

        for(int i = 1; i < 2_000_000; i++){
            if(timeA[i] == timeB[i]){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);

    }

    public static void go(char dir, int num){
        if(dir == 'L'){
            for(int i = 1; i <= num; i++){
                timeA[index] = timeA[index-1] - 1;
                index++;
            }
        }else{
            for(int i = 1; i <= num; i++){
                timeA[index] = timeA[index-1] + 1;
                index++;
            }
        }
        
    }

    public static void go2(char dir, int num){
        if(dir == 'L'){
            for(int i = 1; i <= num; i++){
                timeB[index] = timeB[index-1] - 1;
                index++;
            }
        }else{
            for(int i = 1; i <= num; i++){
                timeB[index] = timeB[index-1] + 1;
                index++;
            }
        }
        
    }
}