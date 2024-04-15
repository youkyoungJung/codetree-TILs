import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int[][] dist = {{-1, 0}, {1, 0}, {0,-1}, {0, 1}};
    static boolean[][] isVisited;
    static int n;
    static int m;
    static int cnt = 0;

    static class Answer implements Comparable<Answer>{
        int k;
        int num; //안전영역의 수

        public Answer(int k, int num){
            this.k = k;
            this.num = num;
        }

        public int compareTo(Answer o){
            if(this.num == o.num){
                return Integer.compare(this.k, o.k);
            }
            return Integer.compare(o.num, this.num);
        }
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int k = 0;
        arr = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                k = Math.max(k, arr[i][j]);
            }
        }

        ArrayList<Answer> answer = new ArrayList<>();

        //안전 지역
        for(int i = 1; i <= k; i++){
            isVisited = new boolean[n][m];
            //dfs
            for(int r = 0; r < n; r++){
                for(int c = 0; c < m; c++){
                    if(!isVisited[r][c] && arr[r][c] > i){
                        isVisited[r][c] = true;
                        dfs(r, c, i);
                        cnt++;
                    }
                }
            }
            answer.add(new Answer(i, cnt));
            cnt = 0;
        }
        Collections.sort(answer);

        System.out.println(answer.get(0).k + " " + answer.get(0).num);

    }//end of main

    public static void dfs(int x, int y, int k){
        for(int i = 0; i < 4; i++){
            int nx = x + dist[i][0];
            int ny = y + dist[i][1];

            if(checked(nx, ny, k)){
                isVisited[nx][ny] = true;
                dfs(nx, ny, k);
            }
        }
    }

    public static boolean checked(int nx, int ny, int k){
        return nx >= 0 && nx < n && ny >= 0 && ny < m  
        && !isVisited[nx][ny] && arr[nx][ny] > k;
    }
}