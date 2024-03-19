import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for(int i = 0; i < N-2; i++){
            for(int j = i+1; j < N-1; j++){
                if(arr[i] <= arr[j]){
                    for(int k = j+1; k < N; k++){
                        if(arr[j] <= arr[k]){
                            cnt++;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}