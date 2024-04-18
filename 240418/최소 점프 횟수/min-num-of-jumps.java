import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static int answer = 10;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        go(0);

        if(answer == 10){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
        
    }

    static ArrayList<Integer> list = new ArrayList<>();
    public static void go(int depth){
        if(depth == n-1){
            answer = Math.min(answer, list.size());
            return;
        }

        for(int i = 1; i <= arr[depth]; i++){
            if(depth+i >= 0 && depth + i < n){ // 배열 범위 안에 있으먄
                list.add(i);
                go(depth+i);
                list.remove(list.size()-1);
            }
        }
    }
}