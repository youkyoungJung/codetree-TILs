import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<Integer> hash = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            hash.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            hash.add(Integer.parseInt(st.nextToken()));
        }

        int include = n+m-hash.size();

        System.out.println(n+m-(2*include));
    }
}