import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static HashSet<Integer> hash = new HashSet<>();
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        System.out.println(findOne(n));

    } //end of main

    public static int findOne(int n){

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{n, 0});
        hash.add(n);

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            if(current[0] == 1){
                return current[1];
            }

            for(int i = 0; i < 4; i++){
                int next = 0;
                if(i == 0){
                    next = go0(current[0]);
                }else if (i == 1){
                    next = go1((current[0]));
                }else if (i == 2){
                    next = go2(current[0]);
                }else{
                    next = go3(current[0]);
                }

                if(!hash.contains(next)){
                    queue.offer(new int[]{next, current[1] + 1});
                    hash.add(next);
                }
            }
        }

        return -1;
    } //end of bfs

    public static int go0(int n){
        return n-1;
    }

    public static int go1(int n){
        return n+1;
    }

    public static int go2(int n){
        if(n % 2 == 0){
            return n / 2;
        }
        return n;
    }
    public static int go3(int n){
        if(n % 3 == 0){
            return n / 3;
        }
        return n;
    }
}//end of class