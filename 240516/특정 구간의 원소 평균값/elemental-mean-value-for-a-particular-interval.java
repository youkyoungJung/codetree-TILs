import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){

                if(i == j){
                    answer++;
                }else{
                    int sum = 0;
                    HashSet<Double> set = new HashSet<>();
                    for(int k = i; k <= j; k++){
                        sum += arr[k];
                        set.add((double)arr[k]);
                    }
                    double avg = (double)sum / (j-i+1);
                    if(set.contains(avg)){
                        // System.out.println("sum : " + sum + " avg: " + avg  + " i : " + i + " j : " +  j);
                        // System.out.println("avg: " + avg + " set: " + set);
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);

    }
}