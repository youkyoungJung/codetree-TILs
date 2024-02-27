import java.util.*;
import java.io.*;

public class Main {
    
    static ArrayList<ArrayList<Integer>> graph;
    static int n;
    static int m;
    static boolean[] isVisited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n+1];
        graph = new ArrayList<>(n+1);
        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(1, -1); //1번 정점 부터 시작
        System.out.println(answer);
    }

    public static void dfs(int num, int current){
        if(current == num){
            return;
        }

        for(int i = 0; i < graph.get(num).size(); i++){
            int next = graph.get(num).get(i);

            if(!isVisited[next]){
                isVisited[next] = true;
                answer++;
                dfs(next, next);
            }
        }
    }

}