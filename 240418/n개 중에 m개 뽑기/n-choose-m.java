import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> nums = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int n, m;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        go(0, 1);

        System.out.println(sb.toString());

    }

    public static void go(int cnt, int current){
        if(current == n+1){
            if(cnt == m){
                for(int i : nums){
                    sb.append(i).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        nums.add(current);
        go(cnt+1, current+1);
        nums.remove(nums.size()-1);

        go(cnt, current + 1);
    }
}