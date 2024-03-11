import java.io.*;
import java.util.*;

public class Main {

    static class Edge{
        int num;
        int val;

        public Edge(int num, int val){
            this.num = num;
            this.val = val;
        }
    }
    static ArrayList<ArrayList<Edge>> graph;
    static int[] nums;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //init
        graph = new ArrayList<>(n+1);
        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<>());
        }
        nums = new int[n+1];
        Arrays.fill(nums, INF);

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Edge(e, v));

        }

        dijkstra(1);
//        System.out.println(Arrays.toString(nums));
        for(int i = 2; i <= n; i++){
            if(nums[i] == INF){
                sb.append(-1).append("\n");
            }else {
                sb.append(nums[i]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void dijkstra(int start){
        nums[start] = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int i = 0; i < graph.get(current).size(); i++){
                Edge next = graph.get(current).get(i);
                if(nums[next.num] > nums[current] + next.val){
                    nums[next.num] = nums[current] + next.val;
                    queue.offer(next.num);
                }

            }
        }

    }
}