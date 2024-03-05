import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] graph;
    static int max = -1;
    static int[][][] dir = {{{-2,0}, {-1,0}, {1,0},{2,0}}, {{-1,0}, {1,0}, {0,-1}, {0,1}}, {{-1,1}, {-1,1}, {1,-1}, {1, 1}}};
    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static ArrayList<Node> bombs = new ArrayList<>();
    static boolean[] visited;
    static boolean[][] boommed;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        boommed = new boolean[n][n];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 1)
                    bombs.add(new Node(i,j));
            }
        }
        visited = new boolean[bombs.size()];

        dfs(0, 0);

        System.out.println(max);


    }

    public static void dfs(int cnt, int total) {
        if(cnt == bombs.size()) {
            max = Math.max(max, total);
            return;
        }
        for(int i = 0; i < bombs.size(); i++) {
            Node b = bombs.get(i);
            if(!visited[i]) {
                visited[i] = true;
                int n1 = 1, n2 =1, n3 = 1;
                boommed[b.r][b.c] = true;
                for(int k = 0; k < 4; k++) {
                    int nr = dir[0][k][0] + b.r;
                    int nc = dir[0][k][1] + b.c;
                    if(inGraph(nr, nc) && !boommed[nr][nc]) {
                        boommed[nr][nc] = true;
                        n1++;
                    }
                }
                for(int k = 0; k < 4; k++) {
                    int nr = dir[0][k][0] + b.r;
                    int nc = dir[0][k][1] + b.c;
                    if(inGraph(nr, nc)  && boommed[nr][nc]) {
                        boommed[nr][nc] = false;
                    }
                }

                for(int k = 0; k < 4; k++) {
                    int nr = dir[1][k][0] + b.r;
                    int nc = dir[1][k][1] + b.c;
                    if(inGraph(nr, nc) && !boommed[nr][nc]) {
                        boommed[nr][nc] = true;
                        n2++;
                    }
                }
                for(int k = 0; k < 4; k++) {
                    int nr = dir[1][k][0] + b.r;
                    int nc = dir[1][k][1] + b.c;
                    if(inGraph(nr, nc)  && boommed[nr][nc]) {
                        boommed[nr][nc] = false;
                    }
                }

                for(int k = 0; k < 4; k++) {
                    int nr = dir[2][k][0] + b.r;
                    int nc = dir[2][k][1] + b.c;
                    if(inGraph(nr, nc) && !boommed[nr][nc]) {
                        boommed[nr][nc] = true;
                        n3++;
                    }
                }
                for(int k = 0; k < 4; k++) {
                    int nr = dir[2][k][0] + b.r;
                    int nc = dir[2][k][1] + b.c;
                    if(inGraph(nr, nc)  && boommed[nr][nc]) {
                        boommed[nr][nc] = false;
                    }
                }

                int m = Math.max(n1, Math.max(n2, n3));


                if(m == n1){for(int k = 0; k < 4; k++) {
                    int nr = dir[0][k][0] + b.r;
                    int nc = dir[0][k][1] + b.c;
                    if(inGraph(nr, nc) && !boommed[nr][nc]) {
                        boommed[nr][nc] = true;
                    }
                }
                dfs(cnt+1, total+n1);
                for(int k = 0; k < 4; k++) {
                    int nr = dir[0][k][0] + b.r;
                    int nc = dir[0][k][1] + b.c;
                    if(inGraph(nr, nc)  && boommed[nr][nc]) {
                        boommed[nr][nc] = false;
                    }
                }}

                if(m == n2){for(int k = 0; k < 4; k++) {
                    int nr = dir[1][k][0] + b.r;
                    int nc = dir[1][k][1] + b.c;
                    if(inGraph(nr, nc) && !boommed[nr][nc]) {
                        boommed[nr][nc] = true;
                    }
                }
                dfs(cnt+1, total+n2);
                for(int k = 0; k < 4; k++) {
                    int nr = dir[1][k][0] + b.r;
                    int nc = dir[1][k][1] + b.c;
                    if(inGraph(nr, nc)  && boommed[nr][nc]) {
                        boommed[nr][nc] = false;
                    }
                }}

                if(m == n3){for(int k = 0; k < 4; k++) {
                    int nr = dir[2][k][0] + b.r;
                    int nc = dir[2][k][1] + b.c;
                    if(inGraph(nr, nc) && !boommed[nr][nc]) {
                        boommed[nr][nc] = true;
                    }
                }
                dfs(cnt+1, total+n3);
                for(int k = 0; k < 4; k++) {
                    int nr = dir[2][k][0] + b.r;
                    int nc = dir[2][k][1] + b.c;
                    if(inGraph(nr, nc)  && boommed[nr][nc]) {
                        boommed[nr][nc] = false;
                    }
                }}
                boommed[b.r][b.c] = false;
                
                visited[i] = false;
            }
        }

    }
    

    public static boolean inGraph(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }
}