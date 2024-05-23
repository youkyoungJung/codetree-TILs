import java.util.*;
import java.io.*;

public class Main {
    static int[] arr = new int[6];
    static int total = 0;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 6; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        } 

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                for(int k = 0; k < 6; k++){
                    if(i != j && j != k && k != i){
                        answer = Math.min(answer, algoDiff(i, j, k));
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static int algoDiff(int i, int j, int k){
        int sum = arr[i] + arr[j] + arr[k];
        int sum2 = total - sum;

        return Math.abs(sum2 - sum);
    }
}