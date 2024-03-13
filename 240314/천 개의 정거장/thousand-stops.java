import java.util.*;
import java.io.*;


//버스 노선의 수 N, 노선을 이루는 점의 개수 범위 R
//처음 그래프를 만드는데 걸리는 시간 O(NR^2)
//다익스트라(인접 행렬) - O(M^2)
public class Main {

    static class Pair {
        long cost;
        long time;

        public Pair(long cost, long time){
            this.cost = cost;
            this.time = time;
        }
        // 비용이 동일할 시 시간이 가장 짧은 경우를 갱신하도록 설계
        public boolean isGreaterThan(Pair p){
            return this.cost > p.cost || (this.cost == p.cost && this.time > p.time);
        }
    }

    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final long INF = (long)1e17 + 1;
    public static final int MAX_M = 1000;

    public static int a, b, n, m = 1000;
    public static Pair[][] graph = new Pair[1001][1001];
    public static boolean[] isVisited = new boolean[10001];

    public static Pair[] dist = new Pair[1001];

    public static void init(){

        // 초기 graph 값에 전부 큰 값 기록
        for(int i = 1; i <= m; i++){
            // 초기 dist
            dist[i] = new Pair(INF, 0);

            for(int j = 1; j <= m; j++){
                graph[i][j] = new Pair(INF, 0);
            }
            // 자기 자신은 비용과 시간이 전혀 소요되지 않음.
            graph[i][i] = new Pair(0, 0);
        }

    }
    public static void main(String[] args) throws IOException{
        // 주어진 버스 노선으로부터 각 지점 쌍에 대해 최소 비용과 최소시간을 담고 있는 그래프 완성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); //지점 a
        int b = Integer.parseInt(st.nextToken()); //지점 b
        int n = Integer.parseInt(st.nextToken()); //버스의 수

        init();

        //인접 행렬 이용 O(M^2)
        // 비용 정보, 걸린 시간 정보 같이 관리
        for(int bus = 1; bus <= n; bus++){
            st = new StringTokenizer(br.readLine());
            int fee = Integer.parseInt(st.nextToken());
            int stopNum = Integer.parseInt(st.nextToken());

            ArrayList<Integer> stations = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < stopNum; i++){
                int x = Integer.parseInt(st.nextToken());
                stations.add(x);
            }
            // 최소 비용이 동일한 경우 - 가능한 시간 중 최솟값 갱신
            for(int i = 0; i < stopNum; i++){
                for(int j = i + 1; j < stopNum; j++){
                    Pair newPair = new Pair(fee, j-i);
                    if(graph[stations.get(i)][stations.get(j)].isGreaterThan(newPair)){
                        graph[stations.get(i)][stations.get(j)] = newPair;
                    }
                }
            }

        } // 버스 경로 저장

        dijkstra(a);

        // 만약 도달이 불가능 하다면 -1, -1
        if(dist[b].cost == INF) dist[b] = new Pair(-1, -1);

        long minCost = dist[b].cost;
        long minTime = dist[b].time;

        System.out.println(minCost + " " + minTime);

    }

    public static void dijkstra(int start){
        dist[start] = new Pair(0, 0);

        for(int i = 1; i <= 1000; i++){
            int minIdx = -1;

            for(int j = 1; j <= 1000; j++){
                if(isVisited[j]) continue;

                if(minIdx == -1 || dist[minIdx].isGreaterThan(dist[j])){
                    minIdx = j;
                }
            }

            isVisited[minIdx] = true; // 정점 방문 표시

            long minCost = dist[minIdx].cost;
            long minTime = dist[minIdx].time;

            // 최솟값에 해당하는 정점에 연결된 간선들을 보며 시작점으로부터의 최단거리 값을 갱신
            for(int j = 1; j <= 1000; j++){
                long cost = graph[minIdx][j].cost;
                long time = graph[minIdx][j].time;

                Pair newPair = new Pair(minCost + cost, minTime + time);
                if(dist[j].isGreaterThan(newPair)){
                    dist[j] = newPair;
                }
            }

        }
    }

}