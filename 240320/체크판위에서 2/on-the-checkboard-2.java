import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] graph;
    static int answer =0;

	public static void main(String[] args) throws IOException {
		// 여기에 코드를 작성해주세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                graph[i][j] = st.nextToken().charAt(0);
            }
        }


        go(0, 0, 0, graph[0][0]);

        System.out.println(answer);
        
	}

    public static void go(int cnt, int r, int c, char ch){
        if(cnt == 3 && r == R- 1 &&c == C-1 ){
            answer++;
            return;
        }
        for(int i = r+1; i < R; i++){
            for(int j = c+1; j < C; j++){
                if(graph[i][j] != ch){
                    go(cnt+1, i, j, graph[i][j]);
                }
            }
        }
    }
}