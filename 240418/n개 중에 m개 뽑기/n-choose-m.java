import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> nums = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] isVisited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n+1];
        go(0, 1);

        System.out.println(sb.toString());

    }

    public static void go(int cnt, int start){
        if(cnt == m){
            for(int i : nums){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <= n; i++){
            if(!isVisited[i])
            isVisited[i] = true;
            nums.add(i);
            go(cnt+1, i+1);
            isVisited[i] = false;
            nums.remove(nums.size()-1);
        }

    }
}