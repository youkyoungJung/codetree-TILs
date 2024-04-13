import java.util.*;
import java.io.*;

public class Main {
    static class Solution implements Comparable<Solution>{
        int p;
        int l;

        public Solution(int p, int l){
            this.p = p;
            this.l = l;
        }

        public int compareTo(Solution o){
            if(this.l == o.l){
                return Integer.compare(o.p, this.p);
            }
            return Integer.compare(o.l, this.l);
        }
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());

        TreeSet<Solution> set = new TreeSet<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); //문제 번호
            int l = Integer.parseInt(st.nextToken()); //문제 난이도

            set.add(new Solution(p, l));
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("ad")){
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                set.add(new Solution(p, l));

            }else if(command.equals("sv")){
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                set.remove(new Solution(p, l));

            }else{ //rc
                int num = Integer.parseInt(st.nextToken());

                if(num == 1){
                    sb.append(set.first().p).append("\n");
                }else{ // -1
                    sb.append(set.last().p).append("\n");
                }

            }
        }

        System.out.println(sb.toString());
    }
}