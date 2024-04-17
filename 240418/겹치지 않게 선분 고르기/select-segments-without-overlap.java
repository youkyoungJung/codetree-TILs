import java.util.*;
import java.io.*;

public class Main {
    static class Pair{
        int s;
        int e;

        public Pair(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
    static ArrayList<Pair> arr = new ArrayList<>();
    static ArrayList<Pair> pick = new ArrayList<>();
    static int n;
    static int res = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            arr.add(new Pair(x1, x2));
        }

        dfs(0);
        System.out.println(res);

    }
    
    public static void dfs(int cnt){
        if(cnt == n){
            res = Math.max(res, calc());
            return;
        }

        pick.add(new Pair(arr.get(cnt).s, arr.get(cnt).e));
        dfs(cnt+1);
        pick.remove(pick.size()-1);
        dfs(cnt+1);
    }

    public static int calc(){
        boolean[] isVisited = new boolean[1001];
        boolean flag = true;
        int answer = 0;

        for(int i = 0; i < pick.size(); i++){
           Pair current = pick.get(i);
           for(int j = current.s; j <= current.e; j++){
                if(!isVisited[j]){
                    isVisited[j] = true;
                }else{
                    flag = false;
                    break;
                }
           }
           if(flag){
                answer++;
           }
        }
        return answer;
    }

}