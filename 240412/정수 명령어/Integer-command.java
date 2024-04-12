import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 0; testCase < t; testCase++){
            int n = Integer.parseInt(br.readLine());

            TreeSet<Integer> set = new TreeSet<>();

            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(command.equals("I")){
                    set.add(num);
                }else if(command.equals("D")){
                    if(!set.isEmpty()){
                        if(num > 0){
                            set.remove(set.last());
                        }else{
                            set.remove(set.first());
                        }
                    }
                }
            }

            if(set.isEmpty()){
                sb.append("EMPTY").append("\n");
            }else{
                sb.append(set.last()).append(" ").append(set.first()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}