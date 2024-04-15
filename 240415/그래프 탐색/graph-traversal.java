import java.util.*;
import java.io.*;

public class Main {

    static boolean[] isVisited;
    static int answer = 0;
    static int n;

    static void dfs(int num, ArrayList<ArrayList<Integer>> graph){
        for(int i = 0; i < graph.get(num).size(); i++){
            int current = graph.get(num).get(i);
            if(!isVisited[current]) {
                answer++;
                isVisited[current] = true;
                dfs(current, graph);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n+1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        isVisited[1] = true;
        dfs(1, graph);
        System.out.println(answer);

    }
}