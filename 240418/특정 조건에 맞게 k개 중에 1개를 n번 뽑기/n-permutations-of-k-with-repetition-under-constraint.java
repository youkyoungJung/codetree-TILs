import java.util.*;
import java.io.*;

public class Main {
    static int k;
    static int n;
    static int answer = 0;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());//k 이하의 숫자
        n = Integer.parseInt(st.nextToken());//n 번반복
        
        //같은 숫자 연속 3번 안됨
        per(0);
        System.out.println(sb);

    }
    
   public static void per(int cnt){
        if(cnt == n){
            if(checked()){
                for(int num : nums){
                    sb.append(num).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        for(int i = 1; i <= k; i++){
            if(cnt >= 2 &&
                i == nums.get(nums.size()-1) &&
                i == nums.get(nums.size()-2)) continue;
            nums.add(i);
            per(cnt+1);
            nums.remove(nums.size()-1);
        }

   }

   public static boolean checked(){
        HashSet<Integer> set = new HashSet<>(); 
        for(int i = 0; i < nums.size(); i++){
            if(!set.contains(nums.get(i))){
                set.add(nums.get(i));
            }else{
                return false;
            }
        }
        return true;
   }
}