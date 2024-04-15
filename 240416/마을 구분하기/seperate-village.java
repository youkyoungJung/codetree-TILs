import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] isVisited;
    static int[][] arr;
    static int n;
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    static int person = 1;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        isVisited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!isVisited[i][j] && arr[i][j] == 1){
                    isVisited[i][j] = true;
                    dfs(i, j);
                    answer.add(person);
                    cnt++;
                    person = 1;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for(int num : answer){
            sb.append(num).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = x + dist[i][0];
            int ny = y + dist[i][1];

            if(checked(nx, ny)){
                isVisited[nx][ny] = true;
                person++;
                dfs(nx, ny);
            }
        }

    }

    public static boolean checked(int nx, int ny){
        return nx >= 0 && nx < n && ny >= 0 && ny < n && !isVisited[nx][ny] && arr[nx][ny] == 1;
    }
}