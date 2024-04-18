import java.util.*;
import java.io.*;

public class Main {
  
    static int[][] arr;
    static int n;
    static ArrayList<Integer> nums = new ArrayList<>();
    static boolean[] isVisited;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        isVisited = new boolean[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0);
        System.out.println(answer);
       
    }

    public static void go(int cnt){
        if(cnt == n){
            //만들어진 nums로 확인
            int res = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                res = Math.min(res, arr[i][nums.get(i)]);
                // System.out.println(res);
            }
            answer = Math.max(answer, res);
            return;
        }

        for(int i = 0; i < n; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                nums.add(i);
                go(cnt+1);
                
                isVisited[i] = false;
                nums.remove(nums.size()-1);
            }
        }
    }

   
}