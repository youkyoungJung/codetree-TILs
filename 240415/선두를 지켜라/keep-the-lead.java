import java.util.*;
import java.io.*;

public class Main {
    static double[] A = new double[1000_001];
    static double[] B = new double[1000_001];

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int second = 1;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            while(t-- > 0){
                A[second] = A[second-1] + v;
                second++;
            }
        }

        second = 1;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            while(t-- > 0){
                B[second] = B[second-1] + v;
                second++;
            }
        }

        int answer = 0;
        int target = 0;
    
        for(int i = 1; i < 1000_001; i++){
            if(A[i] > B[i]){
                if(target == 1){
                    answer++;
                }
                target = 0;
            }else if(A[i] < B[i]){
                if(target == 0){
                    answer++;
                }
                target = 1;
            }
        }

        System.out.println(answer);

    }
}