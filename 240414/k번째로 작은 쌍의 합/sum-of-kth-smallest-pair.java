import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arrA = new int[n];
        int[] arrB = new int[m];
        PriorityQueue<Integer> total = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrB);
        int answer = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                total.offer(arrA[j] + arrB[i]);
            }
            int current = total.poll();
            answer++;

            if(answer == k){
                System.out.println(current);
                return;
            }
        }




    }
}