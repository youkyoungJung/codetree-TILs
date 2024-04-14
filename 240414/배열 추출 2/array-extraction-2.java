import java.util.*;
import java.io.*;

public class Main {
    static class OrderQ implements Comparable<OrderQ>{
        int num;
        int chNum;

        public OrderQ(int num, int chNum){
            this.num = num;
            this.chNum = chNum;
        }

        public int compareTo(OrderQ o){
            if(this.chNum == o.chNum){
                return Integer.compare(this.num, o.num);
            }
            return Integer.compare(this.chNum, o.chNum);
        }
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<OrderQ> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());

            if(num != 0){
                pq.offer(new OrderQ(num, Math.abs(num)));
            }else{ // 0 일 경우
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(pq.poll().num).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}