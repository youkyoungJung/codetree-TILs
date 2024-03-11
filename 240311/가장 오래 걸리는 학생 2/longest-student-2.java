import java.util.*;
import java.io.*;

public class Main {

    static class Edge implements Comparable<Edge>{
        int num;
        int val;

        public Edge(int num, int val){
            this.num = num;
            this.val = val;
        }

        public int compareTo(Edge o){
            return Integer.compare(this.num, o.num);
        }

    }
    static ArrayList<ArrayList<Edge>> graph;
    static int[] nums;
    static int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        nums = new int[n+1];
        Arrays.fill(nums, INF);

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(e).add(new Edge(s, v));
        }

        nums[n] = 0;
        dijkstra(n);
//        System.out.println(Arrays.toString(nums));

        int max = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }

        System.out.println(max);
    }

    public static void dijkstra(int num){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(num, 0));

        while(!pq.isEmpty()){
            Edge current = pq.poll();

            if(current.val != nums[current.num]) continue;

            for(int i = 0; i < graph.get(current.num).size(); i++){
                Edge next = graph.get(current.num).get(i);

                int target = nums[current.num] + next.val;
                if(nums[next.num] > target){
                    nums[next.num] = target;
                    pq.offer(new Edge(next.num, target));
                }
            }
        }

    }
}