import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            char[] input = br.readLine().toCharArray();
            Arrays.sort(input);
            String str = new String(input);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> entrySet = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });
        entrySet.addAll(map.entrySet());

        Map.Entry<String, Integer> answer = entrySet.poll();
        System.out.println(answer.getValue());
    }
}