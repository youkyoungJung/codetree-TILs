import java.util.*;
import java.io.*;

public class Main {

    static class Edge implements Comparable<Edge> {
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
    static int[] nums;
    static int[] path;
    static int INF = (int)1e9;
    static StringBuilder sb = new StringBuilder();
    static int index = 0;

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
        path = new int[n+1];
        Arrays.fill(nums, INF);

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(e).add(new Edge(s, v));
            graph.get(s).add(new Edge(e, v));
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        sb.append(dijkstra(a, b)).append("\n");

//        System.out.println(Arrays.toString(path));
        int x = a;
        ArrayList<Integer> vertices = new ArrayList<>();
        vertices.add(x);
        while(x != b) {
            x = path[x];
            vertices.add(x);
        }

        for(int i = 0; i < vertices.size(); i++){
            sb.append(vertices.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static int dijkstra(int start, int end){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(end, 0));
        nums[end] = 0;

        while(!pq.isEmpty()){
            Edge current = pq.poll();

            if(current.val != nums[current.num]) continue;

            if(current.num == start){
                return current.val;
            }

            for(int i = 0; i < graph.get(current.num).size(); i++){
                Edge next = graph.get(current.num).get(i);

                int target = nums[current.num] + next.val;
                if(nums[next.num] > target){
                    nums[next.num] = target;
                    path[next.num] = current.num;
                    pq.offer(new Edge(next.num, target));
                }
            }

        }
        return -1;

    }
}
//3
//1 4 3 5