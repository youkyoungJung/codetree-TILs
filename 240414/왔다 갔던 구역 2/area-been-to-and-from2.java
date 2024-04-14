import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[201];
        int current = 100;

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String command = st.nextToken();

            if(command.equals("L")){ //왼쪽으로 이동
                for(int j = x; j > 0; j--){
                    arr[current]++;
                    current--;
                }

            }else{ //오른쪽으로 이동
                for(int j = 0; j < x; j++){
                    arr[current]++;
                    current++;
                }

            }
        }

        int answer = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 2){
                answer++;
            }
        }

        System.out.println(answer);

    }
}