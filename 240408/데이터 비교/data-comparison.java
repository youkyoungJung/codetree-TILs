import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0; i < n; i++){
            hashSet.add(Integer.parseInt(st.nextToken()));
           
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        // HashSet<Integer> hashSet2 = new HashSet<>();
        for(int i = 0; i < m; i++){
             arr[i] = Integer.parseInt(st.nextToken());
            // hashSet2.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            if(hashSet.contains(arr[i])){
                sb.append(1).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}