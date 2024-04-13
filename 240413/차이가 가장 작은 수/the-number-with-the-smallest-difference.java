import java.util.*;
import java.io.*;

public class Main {
    static int INF = (int)1e9+1;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();
        int answer = INF;
        for(int i = 0; i < n; i++){
            set.add(Integer.parseInt(br.readLine()));
        } //end of for

        ArrayList<Integer> arr = new ArrayList<>(set);

        int s = 0;
        int e = arr.size()-1;

        while(s <= e){
            int target = arr.get(s);
//             System.out.println("s: " + target);
//             System.out.println("e: " + arr.get(e));
            if(m <= Math.abs(arr.get(e) - target)){
                answer = Math.min(answer, Math.abs(arr.get(e) - target));
                e--;
            }else{
                s++;
            }
        }

        if(answer == INF){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }
}