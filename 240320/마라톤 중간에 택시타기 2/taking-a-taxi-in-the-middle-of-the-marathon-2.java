import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static class CheckPoint{
        int x, y;
        public CheckPoint(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static CheckPoint[] cps;
    static int min = Integer.MAX_VALUE;


	public static void main(String[] args) throws IOException {
		// 여기에 코드를 작성해주세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());
        cps = new CheckPoint[N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            cps[i] = new CheckPoint(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        go(0, 1, 0);

        System.out.println(min);


	}

    public static int dist(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }

    public static void go(int idx, int cnt, int sum){
        if(cnt == N-1 && idx == N-1){
            min =Math.min(min, sum);
            return;
        }
        for(int i = idx+1; i < N; i++){
            go(i, cnt+1, sum + dist(cps[idx].x, cps[idx].y , cps[i].x, cps[i].y));
        }
    }


}