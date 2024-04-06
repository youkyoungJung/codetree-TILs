import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for(int i = 0; i < input.length; i++){
            char c = input[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        });
        queue.addAll(map.entrySet());
        Map.Entry<Character, Integer> answer = queue.poll();
        if(answer.getValue() != 1){
            System.out.println("None");
        }else{
            System.out.println(answer.getKey());
        }
    }
}