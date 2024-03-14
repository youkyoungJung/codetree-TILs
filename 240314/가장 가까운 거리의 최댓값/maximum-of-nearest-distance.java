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
    static HashSet<Integer> nums;
    static int INF = (int)1e9+1;

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


        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        nums = new HashSet<>(3);
        nums.add(a);
        nums.add(b);
        nums.add(c);

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Edge(e, v));
            graph.get(e).add(new Edge(s, v));
        }

        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            Arrays.fill(dist, INF);
            int res = dijkstra(i);
            answer = Math.max(answer, res);
        }
        System.out.println(answer);
    }
    public static int dijkstra(int num){
        dist[num] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(num, 0));

        while(!pq.isEmpty()){
            Edge current = pq.poll();

            if(dist[current.num] < current.val) continue;

            for(int i = 0; i < graph.get(current.num).size(); i++){
                Edge next = graph.get(current.num).get(i);

                if(dist[next.num] > dist[current.num] + next.val){
                    dist[next.num] = dist[current.num] + next.val;
                }
            }
        }

//        System.out.println("num:: " + num + Arrays.toString(dist));
        int answer = Integer.MAX_VALUE;
        for(int target : nums){
            if(target !=  num && answer > dist[target]){
                answer = dist[target];
            }
        }
        return answer;
    }
}