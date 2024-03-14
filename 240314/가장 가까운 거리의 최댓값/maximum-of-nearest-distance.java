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

    static int[] minDist;
    static HashSet<Integer> nums;
    static int INF = (int)1e9;

    static int n;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        dist = new int[n+1];

        minDist = new int[n+1];
        Arrays.fill(minDist, INF);


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

        //a,b,c 다익스트라
        dijkstra(a);
        dijkstra(b);
        dijkstra(c);

        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            answer = Math.max(answer, minDist[i]);
        }
        System.out.println(answer);
    }

    public static void dijkstra(int num){
        Arrays.fill(dist, INF);
        dist[num] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(num, 0));

        while(!pq.isEmpty()){
            Edge current = pq.poll();

            if(dist[current.num] != current.val) continue;

            for(int i = 0; i < graph.get(current.num).size(); i++){
                Edge next = graph.get(current.num).get(i);

                if(dist[next.num] > dist[current.num] + next.val){
                    dist[next.num] = dist[current.num] + next.val;
                    pq.add(new Edge(next.num,  dist[current.num] + next.val));
                }
            }
        }

        // 각 지점에 대한 최단거리 값 중 최솟값을 갱신해줍니다.
        for(int i = 1; i <= n; i++) {
            minDist[i] = Math.min(minDist[i], dist[i]);
        }
//        System.out.println(Arrays.toString(minDist));

    }
}
//42591