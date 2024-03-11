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

        public int compareTo(Edge o){?
            if(this.val == o.val){
                return Integer.compare(this.num, o.num);
            }
            return Integer.compare(this.val, o.val);
        }
    }

    static ArrayList<ArrayList<Edge>> graph;
    static int[] path;
    static int[] nums;
    static int INF = (int)1e9;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        path = new int[n+1];
        nums = new int[n+1];
        Arrays.fill(nums, INF);
        graph = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Edge(e, v));
            graph.get(e).add(new Edge(s, v));
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(a, b));
        System.out.println(sb.toString());

    }

    public static int dijkstra(int start, int end){
        nums[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge current = pq.poll();

            if(nums[current.num]!=current.val) continue;
            sb.append(current.num).append(" ");
            if(end == current.num){ 
                return current.val;
            }
            for(int i = 0; i < graph.get(current.num).size(); i++){
                Edge next = graph.get(current.num).get(i);

                int target = nums[current.num] + next.val;
                if(nums[next.num] > target){
                    nums[next.num] = target;
                    pq.offer(new Edge(next.num, target));

                    
                }
            }
        }

        return -1;

    }
}