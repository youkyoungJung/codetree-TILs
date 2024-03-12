import java.util.*;
import java.io.*;

public class Main {

    static int[] dist;
    static int[][] graph;
    static int INF = (int)1e9;
    static boolean[] isVisited;
    static int[] path;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); //지점 a
        int b = Integer.parseInt(st.nextToken()); //지점 b
        int n = Integer.parseInt(st.nextToken()); //버스의 수

        graph = new int[1001][1001];
        path = new int[10001];
        isVisited = new boolean[1001];
        dist = new int[1001];
        Arrays.fill(dist, INF);

        for(int bus = 1; bus <= n; bus++){
            st = new StringTokenizer(br.readLine());
            int fee = Integer.parseInt(st.nextToken());
            int station = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < station; i++){
                int desti = Integer.parseInt(st.nextToken());
                graph[desti][station] = fee;
            }
        } // 버스 경로 저장

        dijkstra(b);
        System.out.println(dist[a]+ " " + graph[path[a]][a]);
        

    }

    public static void dijkstra(int start){
        dist[start] = 0;

        for(int i = 1; i <= 1000; i++){
            int minIdx = -1;

            for(int j = 1; j <= 1000; j++){
                if(isVisited[j]) continue;

                if(minIdx == -1 || dist[minIdx] > dist[j]){
                    minIdx = j;
                }
            }

            isVisited[minIdx] = true; // 정점 방문 표시

            for(int j = 1; j <= 1000; j++){
                if(graph[minIdx][j] == 0) continue;

                //통행료 검사
                int tranfee = graph[minIdx][j];
                if(dist[minIdx] != tranfee){
                    dist[j] = Math.min(dist[j], dist[minIdx] + graph[minIdx][j]);
                    path[j] = minIdx;
                }
            }

        }
    }

}