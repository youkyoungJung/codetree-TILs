import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        for(int i = 1; i <= n; i++){
            String s = br.readLine();
            map.put(s, i);
            map2.put(i, s);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            String s = br.readLine();
            if(s.charAt(0) >= 'a'){
                sb.append(map.get(s));
            }else{
                sb.append(map2.get(Integer.parseInt(s)));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}