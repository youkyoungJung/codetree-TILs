import java.util.*;
import java.io.*;

public class Main {

    static int INF = (int)1e9;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n+1][n+1];
        //init
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                graph[i][j] = INF;
            }
            graph[i][i] = 0;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[s][e] = v;
        }

        //floydWarshall

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int isGo = 0;
        int answer = 0;
        for(int testCase = 0; testCase < q; testCase++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(graph[start][end] != INF){
                isGo++;
                answer += graph[start][end];
            }

        }
        System.out.println(isGo);
        System.out.println(answer);
    }
}