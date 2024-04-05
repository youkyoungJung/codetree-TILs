import java.util.*;
import java.io.*;

public class Main {

    static class Location {
        int num;
        int cost;

        public Location (int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }

    static class Edge{
        int num;
        int val;

        public Edge(int num, int val){
            this.num = num;
            this.val = val;
        }
    }

    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>(201);


    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());


        for(int i = 0; i < 201; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Edge(e, v));
        }

        int isGo = 0;
        int answer = 0;
        for(int testCase = 0; testCase < q; testCase++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int res = goCost(start, end);

            if(res != -1){
                isGo++;
                answer += res;
            }
        }
        System.out.println(isGo);
        System.out.println(answer);
    }
    public static int goCost(int start, int end){
        Queue<Location> queue = new ArrayDeque<>();
        queue.offer(new Location(start, 0));

        while(!queue.isEmpty()){
            Location current = queue.poll();

            int cNum = current.num;
            int cCost = current.cost;

            if(cNum == end) return current.cost;

            for(int i = 0; i < graph.get(cNum).size(); i++){
                queue.offer(new Location(graph.get(cNum).get(i).num, cCost + graph.get(cNum).get(i).val));
                if(graph.get(cNum).get(i).num == end) return cCost + graph.get(cNum).get(i).val;
            }
        }
        return -1; // 만나지 못했을 경우.
    }
}