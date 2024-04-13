import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            queue.offer(Integer.parseInt(st.nextToken()));
            if(queue.size() < 3){
                sb.append(-1).append("\n");
            }else{
                int first = queue.poll();
                int second = queue.poll();
                int third = queue.poll();
                sb.append(first * second * third).append("\n");
                queue.offer(first);
                queue.offer(second);
                queue.offer(third);
            }
        }
        System.out.println(sb.toString());
    }
}