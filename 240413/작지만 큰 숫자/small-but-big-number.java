import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int num = Integer.parseInt(st.nextToken());
            // int target = set.floor(num);

            if(set.floor(num) != null){
                sb.append(set.floor(num)).append("\n");
                set.remove(set.floor(num));
            }else{
                sb.append(-1).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}