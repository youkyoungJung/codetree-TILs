import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double answer = Integer.MIN_VALUE;

        int[] arr = new int[n+1];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        queue.offer(arr[n]);

        sum += arr[n];
        for(int i = n-1; i >= 2; i--){
            queue.add(arr[i]);
            sum += arr[i];

            double avg = (double)(sum - queue.peek()) / (n-i);

            answer = Math.max(answer, avg);
        }



        System.out.printf("%.2f", answer);
    }
}