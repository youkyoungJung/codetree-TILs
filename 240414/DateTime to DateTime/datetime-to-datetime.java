import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int answer = (a*24*60 + b*60 + c) - (11*24*60 + 11*60 + 11);
        
        if(answer < 0){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
       


    }
}