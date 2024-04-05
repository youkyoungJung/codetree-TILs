import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        if(o1.getValue() == o2.getValue()){
                            return Integer.compare(o2.getKey(), o1.getKey());
                        }
                        return Integer.compare(o2.getValue(), o1.getValue());
                    }
                }
        );
        queue.addAll(map.entrySet());


        for(int i = 0; i < k; i++){
            System.out.print(queue.poll().getKey() + " ");
        }

    }
}