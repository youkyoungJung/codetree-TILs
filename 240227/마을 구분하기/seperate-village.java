import java.util.*;
import java.io.*;

public class Main {

    static boolean[][] isVisited;
    static int[][] arr;
    static int n;
    static ArrayList<Integer> count;
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//상, 하, 좌, 우
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        isVisited = new boolean[n][n];
        count = new ArrayList<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!isVisited[i][j] && arr[i][j] == 1){

                    isVisited[i][j] = true;
                    dfs(i, j); //i, j
                    count.add(answer);
                    answer = 1;
                }
            }
        }
        sb.append(count.size()).append("\n");
        Collections.sort(count);

        for(int i = 0; i < count.size(); i++){
            sb.append(count.get(i)).append("\n");
        }
        System.out.println(sb);

    }

    public static void dfs(int r, int c){

        for(int i = 0; i < 4; i++){
            int nr = r + dist[i][0];
            int nc = c + dist[i][1];

            if(checked(nr, nc)){
                isVisited[nr][nc] = true;
                answer++;
                dfs(nr, nc);
            }
        }
    }

    public static boolean checked(int r, int c){
        if(r >= 0 && r < n && c >= 0 && c < n && !isVisited[r][c] && arr[r][c] != 0){
            return true;
        }
        return false;
    }

}