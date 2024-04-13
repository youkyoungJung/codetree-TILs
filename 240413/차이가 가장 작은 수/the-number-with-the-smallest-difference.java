import java.util.*;
import java.io.*;

public class Main {
    static int INF = (int)1e9+1;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();
        int answer = INF;
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());

            set.add(num);
            
            if(set.ceiling(num + m) != null){
                answer = Math.min(answer, set.ceiling(num+m) - num);
            }

            if(set.floor(num - m) != null){
                answer = Math.min(answer, num - set.floor(num-m));
            }
        } //end of for

        if(answer == INF){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }
}