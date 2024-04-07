import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(s.equals("add")){
                int key = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());

                map.put(key, val);

            }else if(s.equals("find")){
                int key = Integer.parseInt(st.nextToken());

                if(map.containsKey(key)){
                    sb.append(map.get(key)).append("\n");
                }else{
                    sb.append("None").append("\n");
                }

            }else if(s.equals("remove")){
                int key = Integer.parseInt(st.nextToken());

                if(map.containsKey(key)){
                    map.remove(key);
                }

            }else{ //print_list
                if(!map.isEmpty()) {
                    Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Integer, Integer> entry = iterator.next();
                        sb.append(entry.getValue()).append(" ");
                    }
                    sb.append("\n");
                }else{
                    sb.append("None").append("\n");
                }
            }
//            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}