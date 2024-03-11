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
            return Integer.compare(this.val, o.val);
        }
    }
    static ArrayList<ArrayList<Edge>> graph;
    static boolean[] isVisited;
    static int[] nums;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        nums = new int[n+1];
        Arrays.fill(nums, INF);
        isVisited = new boolean[n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Edge(e, v));
            graph.get(e).add(new Edge(s, v));
        }
        dijkstra(k);
//        System.out.println(Arrays.toString(nums));
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            if(nums[i] == INF){
                sb.append(-1).append("\n");
            }else {
                sb.append(nums[i]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void dijkstra(int n){

        nums[n] = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(n, 0));

        while(!queue.isEmpty()){
            Edge current = queue.poll();

            if(current.val != nums[current.num]) continue;

           for(int i = 0; i < graph.get(current.num).size(); i++){
               Edge next = graph.get(current.num).get(i);

               int newDist = nums[current.num] + next.val;
               if(nums[next.num] > newDist){
                   nums[next.num] = newDist;
                   queue.offer(new Edge(next.num, newDist));
               }
           }
        }
    }
}