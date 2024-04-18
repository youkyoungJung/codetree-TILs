import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> nums = new ArrayList<>();
    static int n;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        isVisited = new boolean[n+1];
        per(0);
        System.out.println(sb);
    }

    public static void per(int cnt){
        if(cnt == n){
            for(int i : nums){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                nums.add(i);
                per(cnt+1);

                isVisited[i] = false;
                nums.remove(nums.size()-1);
            }
        }
    }
}