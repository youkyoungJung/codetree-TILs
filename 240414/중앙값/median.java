import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int testCase = 0; testCase < t; testCase++){
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2)-> {return Integer.compare(o2, o1);});
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine()); 
            for(int i = 1; i <= n; i++){
                int num = Integer.parseInt(st.nextToken());

                if(minHeap.size() == maxHeap.size()){
                    maxHeap.offer(num);
                }else{
                    minHeap.offer(num);
                }

                if(!minHeap.isEmpty()){
                    if(maxHeap.peek() > minHeap.peek()){
                        int t1 = maxHeap.poll();
                        int t2 = minHeap.poll();

                        maxHeap.offer(t2);
                        minHeap.offer(t1);
                    }
                }

                if(i % 2 != 0){
                    sb.append(maxHeap.peek()).append(" ");
                }

            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
        
    }
}