import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n+1][n+1];
        //init
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                graph[i][j] = (int)1e9;
            }
            graph[i][i] = 0;
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken()); //출발 1
        int v2 = Integer.parseInt(st.nextToken()); //출발 2
        int e = Integer.parseInt(st.nextToken()); //도착점

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = c;
            graph[b][a] = c;
        }

        //floydWarshall
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        //gess an answer
        int answer = (int)1e9;
        for(int i = 1; i <= n; i++){
            answer = Math.min(answer, graph[v1][i] + graph[v2][i] + graph[i][e]);
        }

        if(answer >= (int)1e9){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }

    }
}