import java.util.*;
import java.io.*;

public class Main {
    static int k;
    static int n;
    // static ArrayList<Integer> nums = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        dfs(0);
        System.out.println(sb);
    
    }
    public static void dfs(int cnt){
        if(cnt == n){
            for(int i : nums){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= k; i++){
            nums.add(i);
            dfs(cnt+1);
            nums.remove(nums.size()-1);
        }
    }
}