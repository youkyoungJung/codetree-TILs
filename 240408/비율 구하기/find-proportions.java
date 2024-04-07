import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            // System.out.printf("%.4f%n",(double)entry.getValue()/5 * 100);
            sb.append(entry.getKey()).append(" ").append(String.format("%.4f",(double)entry.getValue()/5 * 100)).append("\n");
        }
        System.out.println(sb.toString());
    }
}