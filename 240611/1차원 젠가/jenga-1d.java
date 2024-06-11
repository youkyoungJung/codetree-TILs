import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
       
        for(int i = 1; i <= n; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }
        
        for(int i = 0; i < 2; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            // System.out.println(arr);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;

            for(int t = 0; t < arr.size(); t++){
                if(t < s || t > e){
                    temp.add(arr.get(t));
                }
            }
            // System.out.println(temp);
            arr = temp;
        }

        System.out.println(arr.size());

        if(arr.size() > 0){
            for(int i = 0; i < arr.size(); i++){
                System.out.println(arr.get(i));
            }
        }
    }
}