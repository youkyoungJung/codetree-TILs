import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(set.higher(num) != null){
                answer = Math.min(answer, set.higher(num) - num);
            }
            answer = Math.min(answer, num - set.lower(num));
            set.add(num);
            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());

    }
}