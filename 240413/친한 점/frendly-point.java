import java.util.*;
import java.io.*;

public class Main {
    static class Location implements Comparable<Location>{

        int x;
        int y;

        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int compareTo(Location o){
            if(this.x == o.x){
                return Integer.compare(this.y, o.y);
            }
            return Integer.compare(this.x, o.x);
        }

    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<Location> set = new TreeSet<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            set.add(new Location(x, y));
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(set.ceiling(new Location(x, y)) != null){
                Location current = set.ceiling(new Location(x, y));
                sb.append(current.x).append(" ").append(current.y).append("\n");
            }else{
                sb.append(-1).append(" ").append(-1).append("\n");
            }

        }

        System.out.println(sb.toString());
        
    }
}