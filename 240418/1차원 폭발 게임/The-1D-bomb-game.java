import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            int target = Integer.parseInt(br.readLine());
            if(i == 0){
                stack.add(target);
            }else{
                if(!stack.isEmpty()){
                    int num = stack.peek();

                    if(num != target){
                        stack.add(target);
                    }else{
                        stack.pop();
                    }
                }
            }
        }

        System.out.println(stack.size());
        for(int i : stack){
            System.out.println(i);
        }
        

    }
}