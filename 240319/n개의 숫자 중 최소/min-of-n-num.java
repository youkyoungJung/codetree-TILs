import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException {
		// 여기에 코드를 작성해주세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min= Long.MAX_VALUE;
        int cnt = 0;
		while(st.hasMoreTokens()){
			long x = Long.parseLong(st.nextToken());
            if(x < min){
                min = x;
                cnt =1;
            } else if(x == min){
                cnt+=1;
            }
		}
		System.out.println(min + " " + cnt);
	}
}