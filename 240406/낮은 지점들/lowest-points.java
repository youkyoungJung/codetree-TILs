import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());

        HashMap<Long, Long> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
//            if(map.containsKey(x)){
//                long value = Math.min(map.get(x), y);
//                map.put(x, value);
//            }else{
//                map.put(x, y);
//            }
            map.put(x, Math.min(map.getOrDefault(x, Long.MAX_VALUE), y));
        }

        long answer = 0;
        for(Long x : map.keySet()){
            answer += map.get(x);
        }

        System.out.println(answer);
    }
}