import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> AB = new HashMap<>();
        HashMap<Integer, Integer> CD = new HashMap<>();

        int[][] arr = new int[4][n];
        for(int i = 0; i < 4; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                AB.put(arr[0][i] + arr[1][j], AB.getOrDefault(arr[0][i] + arr[1][j], 0) + 1);
                CD.put(arr[2][i] + arr[3][j], CD.getOrDefault(arr[2][i] + arr[3][j], 0) + 1);
            }
        }

        int answer = 0;
        for(Map.Entry<Integer, Integer> entry : AB.entrySet()){
            int diff = -1 * (entry.getKey());
            if(CD.containsKey(diff)){
                answer += (CD.get(diff) * entry.getValue());
            }
        }
        System.out.println(answer);

    }
}