import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 1; i <= m; i++){
            set.add(i);
        }

        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!set.contains(num)){ //num 이 없어
                if(set.lower(num)!= null){
                    int j = set.lower(num);
                    set.remove(j);
                    answer++;

                }else{
                    System.out.println(answer);
                    return;
                }
            }else{
                set.remove(num);
                answer++;
            }
        }

        System.out.println(answer);
    }
}