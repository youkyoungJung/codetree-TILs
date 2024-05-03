import java.util.*;
import java.io.*;

public class Main {

    static class Location{
        int x;
        int y;
        
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Location> maratons;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        maratons = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            maratons.add(new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int minDist = Integer.MAX_VALUE;

        for(int i = 1; i < n-1; i++){
            Location target = maratons.get(i);
            maratons.remove(i);
            int res = 0;
            for(int j = 1; j < maratons.size(); j++){
                Location pre = maratons.get(j-1);
                Location cur = maratons.get(j);

                int dist = Math.abs(pre.x - cur.x) + Math.abs(pre.y - cur.y);
                res += dist;
            }
            minDist = Math.min(minDist, res);
            maratons.add(i, target);
        }

        System.out.println(minDist);
    }
}