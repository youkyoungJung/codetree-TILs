import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                for(int j = i+1; j < s.length(); j++){
                    if(s.charAt(j) == ')'){
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}