import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] graph;

	public static void main(String[] args) throws IOException {
		// 여기에 코드를 작성해주세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N-2; j++){
                int cnt = 0;
                for(int k = j; k < j+3; k++){
                    if(graph[i][k] == 1){
                        cnt++;
                    }
                }
                max = Math.max(cnt, max);
            }
        }
        System.out.println(max);
        



	}
}