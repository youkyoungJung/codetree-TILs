import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[] temp = new int[n+1];

        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken());
        int e1 = Integer.parseInt(st.nextToken());

        int index = 0;
        for(int i = s1; i < e1; i++){
            arr[i] = 0;
        }
        for(int i = 1; i <= n; i++){
            if(arr[i] != 0){
                temp[index++] = arr[i];
            }
        }

        for(int i = 1; i <= n; i++){
            arr[i] = temp[i];
        }
        // System.out.println(Arrays.toString(arr));

        st = new StringTokenizer(br.readLine());
        int s2 = Integer.parseInt(st.nextToken());
        int e2 = Integer.parseInt(st.nextToken());

        temp = new int[n+1];
        index = 0;
        for(int i = 1; i <= n; i++){
            if(i < s2 || e2-1 < i){
                temp[index++] = arr[i];
            }
        }

        for(int i = 1; i <= n; i++){
            arr[i] = temp[i];
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < index-1; i++){
            if(arr[i] == 0) continue;
            sb.append(arr[i]).append("\n");
            cnt++;

        }

        System.out.println(cnt);
        System.out.println(sb);
    }
}