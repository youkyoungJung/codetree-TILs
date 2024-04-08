import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashSet<Integer> hashSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(command.equals("add")){
                hashSet.add(num);
            }else if(command.equals("remove")){
                if(hashSet.contains(num)){
                    hashSet.remove(num);
                }
            }else{ //find
                sb.append(hashSet.contains(num)).append("\n");
            }

        }

        System.out.println(sb.toString());
    }
}