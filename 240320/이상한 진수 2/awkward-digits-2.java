import java.io.*;
import java.util.*;

public class Main {

    static String a;
    static int max = -1;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// 여기에 코드를 작성해주세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        arr = new char[a.length()];
        for(int i = 0; i < a.length(); i++){
            arr[i] = a.charAt(i);
        }
        for(int i = 0; i < a.length(); i++){
            sb.setLength(0);
            char[] temp = arr.clone();
            if(temp[i] == '0')
                temp[i] = '1';
            else
                temp[i] = '0';
            for(int j = 0; j < a.length(); j++){
                sb.append(temp[j]);
            }
            max = Math.max(Integer.parseInt(sb.toString(), 2), max);
        }
        System.out.println(max);

	}
}