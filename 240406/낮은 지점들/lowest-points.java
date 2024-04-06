import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(map.containsKey(x)){
                int value = Math.min(map.get(x), y);
                map.put(x, value);
            }else{
                map.put(x, y);
            }
//            map.put(x, map.getOrDefault(x, 0) +  Math.min(map.get(x), y));
        }

        int answer = 0;
        for(Integer x : map.keySet()){
            answer += map.get(x);
        }

        System.out.println(answer);
    }
}