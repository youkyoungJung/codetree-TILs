import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] A = new int[n];
        int[] B = new int[m];
        int[] tmp = new int[m];

        HashMap<Integer, Integer> check = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B);
        // System.out.println(Arrays.toString(B));

        int answer = 0;
        for(int i = 0; i <= n-m; i++){
            for(int j = 0; j < m; j++){
                tmp[j] = A[i+j];
            }
            Arrays.sort(tmp);
            // System.out.println(Arrays.toString(tmp));
            boolean isSame = true;
            for(int j = 0; j < m; j++){
                if(tmp[j] != B[j]){
                    isSame = false;
                    break;
                }
            }
            if(isSame){
                answer++;
            }
        
        }
       
       System.out.println(answer);

    }
}