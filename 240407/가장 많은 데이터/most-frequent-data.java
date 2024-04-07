import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        int answer = 0;
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            if(!map.containsKey(s)){
                map.put(s, 1);
            }else{
                map.put(s, map.get(s) + 1);
                answer = Math.max(answer, map.get(s));
            }
        }
        System.out.println(answer);
    }
}