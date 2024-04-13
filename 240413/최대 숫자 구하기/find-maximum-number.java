import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>((o1, o2)->{return Integer.compare(o2, o1);});
        for(int i = 1; i <= m; i++){
            set.add(i);
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(set.remove(num)){
                sb.append(set.first()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}