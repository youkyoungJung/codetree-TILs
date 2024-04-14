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

        
        int day = (c-11);
        int dayTomin = (a-11) * 24 * 60;
        int hourTomin = (b-11) * 60;

        int answer = dayTomin + hourTomin + day;
        if(answer < 0){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
       


    }
}