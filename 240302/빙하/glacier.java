import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    Point(int x ,int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final int MAX_SIZE = 200;
    public static int n, m;
    public static int[][] grid = new int[MAX_SIZE][MAX_SIZE];

    public static int lastCnt = 0;

    public static boolean[][] isVisited;

    public static Queue<Point> q = new ArrayDeque<>();

    public static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static boolean checked(int x, int y) {
        return  0 <= x && x < n && 0 <= y && y < m && !isVisited[x][y];
    }


    public static boolean hasIce() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    return true;
            }
        }
        return false;
    }

    public static void BFS(int x, int y) {

        isVisited[x][y] = true;
        q.offer(new Point(x, y));

        int cnt = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dist[i][0];
                int ny = now.y + dist[i][1];
                if (checked(nx, ny)) {
                    isVisited[nx][ny] = true;
                    if (grid[nx][ny] == 0)
                        q.offer(new Point(nx, ny));
                    else {
                        cnt ++;
                        grid[nx][ny] = 0;
                    }
                }
            }
        }
        lastCnt = cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int time = 1; time <= n*m; time++) {
            isVisited = new boolean[n][m];

            BFS(0, 0);

            if(!hasIce()) {
                System.out.println(time + " " + lastCnt);
                break;
            }

        }
    }
}