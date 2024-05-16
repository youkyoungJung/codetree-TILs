import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){

                int sum = 0;
                HashSet<Integer> set = new HashSet<>();
                for(int k = i; k < j; k++){
                    sum += arr[k];
                    set.add(arr[k]);
                }
                int avg = sum / (j-i);

                if(set.contains(avg)){
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }
}