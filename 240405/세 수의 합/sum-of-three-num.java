import java.util.*;
import java.io.*;

public class Main {
    static HashMap<Integer, Integer> map = new LinkedHashMap<>();
    static int answer = 0;
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        // 1. HashMap 입력해서 서로 다른 숫자 입력 받기
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        // 2. 세수 더한 값 중 k 값 찾기
       for(int i = 0; i < n; i++){
           map.put(arr[i], map.getOrDefault(arr[i], 0) -1);
           for(int j = 0; j < i; j++){
                if(map.containsKey(k-arr[i]-arr[j])){
                    answer += map.get(k-arr[i]-arr[j]);
                }
           }
       }

        System.out.println(answer);
    }

}