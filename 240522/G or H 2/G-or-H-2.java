import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] line = new int[101];

        for(int i = 0 ; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            if(c == 'G'){line[num] = 1;}
            else{line[num] = 2;}

        }
        // System.out.println(Arrays.toString(line));
        int answer = 0;

        for(int i = 0; i <= 100; i++){
            for(int j = i+1; j <= 100; j++){
                if(line[i] == 0 || line[j] == 0) continue;

                int cntG = 0;
                int cntH = 0;

                for(int k = i; k <= j; k++){
                    if(line[k] == 1){
                        cntG++;
                    }else if(line[k] == 2){
                        cntH++;
                    }
                }

                if(cntG == 0 || cntH == 0 || cntG == cntH){
                    answer = Math.max(answer, j - i);
                }
            }
        }
        System.out.println(answer);
    }
}