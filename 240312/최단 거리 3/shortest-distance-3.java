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
    static int[] dist;
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
        dist = new int[n+1];
        Arrays.fill(dist, INF);

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

        dijkstra(b);
        System.out.println(dist[a]);
    }

    public static void dijkstra(int start){

        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge current = pq.poll();

            for(int i = 0; i < graph.get(current.num).size(); i++){
                Edge next = graph.get(current.num).get(i);

                int target = dist[current.num] + next.val;
                if(dist[next.num] > target){
                    dist[next.num] = target;
                    pq.offer(new Edge(next.num, target));
                }
            }
        }
    
    }
}