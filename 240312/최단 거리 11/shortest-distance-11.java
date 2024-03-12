import java.util.*;
import java.io.*;

public class Main {
    static int[] nums;
    static int INF = (int)1e9;

    static int[][] graph;
    static int n;
    static boolean[] isVisited;

    public static void main(String[] args)throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nums = new int[n+1];
        isVisited = new boolean[n+1];
        Arrays.fill(nums, INF);
        graph = new int[n+1][n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[s][e] = v;
            graph[e][s] = v;
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        dijkstra(b);
        System.out.println(nums[a]);

        int x = a;
        sb.append(x).append(" ");
        while(x != b){
            for(int i = 1; i <= n; i++){
                if(graph[i][x] == 0) continue;
                if(nums[i] + graph[i][x] == nums[x]){
                    x = i;
                    break;
                }
            }
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString());

    }

    public static void dijkstra(int start){
        nums[start] = 0;

        for(int i = 1; i <= n; i++){
            int minIdx = -1;
            for(int j = 1; j <= n; j++){
                if(isVisited[j]) continue;

                if(minIdx == -1 || nums[minIdx] > nums[j]){
                    minIdx = j;
                }
            }

            isVisited[minIdx] = true;
            for(int j = 1; j <= n; j++){
                if(graph[minIdx][j] == 0) continue;

                if(nums[j] > nums[minIdx] + graph[minIdx][j]){
                    nums[j] = nums[minIdx] + graph[minIdx][j];
                }
            }
        }
    }
}