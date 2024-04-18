import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> nums = new ArrayList<>();
    static int n;
    static int[][] arr;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        isVisited = new boolean[n+1];

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        per(0);
        System.out.println(answer);
    }

    static int answer = Integer.MAX_VALUE;
    public static void per(int cnt){
        if(cnt == n-1){
            //총 최소 비용 확인
            int res = 0;
            int temp = 1;
            // System.out.println(nums);
            for(int i = 0; i < nums.size(); i++){ //행
                int target = arr[temp][nums.get(i)];
                if(target == 0){
                    return;
                }
                res += target;
                temp = nums.get(i);
            }

            int target = arr[temp][1];
            if(target == 0) return;

            res += target;
            // System.out.println(res);
            answer = Math.min(answer, res);
            return;
        }

        for(int i = 2; i <= n; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                nums.add(i);
                per(cnt+1);

                isVisited[i] = false;
                nums.remove(nums.size()-1);
            }
        }
    }
}