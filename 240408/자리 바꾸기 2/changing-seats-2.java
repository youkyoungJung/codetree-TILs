import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class Main {

    static class Round{
        int a;
        int b;

        public Round(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    static HashMap<Integer, Integer> map = new HashMap<>();
    static  ArrayList<HashSet<Integer>> hashSet;

    static ArrayList<Round> sequence;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        sequence = new ArrayList<>(k);

        //초기화
        hashSet = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++){
            hashSet.add(new HashSet<>());
            hashSet.get(i).add(i);
            map.put(i, i);
        }

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sequence.add(new Round(a, b));
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < k; j++){
                int a = sequence.get(j).a;
                int b = sequence.get(j).b;
                changeAb(a, b);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            sb.append(hashSet.get(i).size()).append("\n");
        }
        System.out.println(sb.toString());

    }
    static void changeAb(int a, int b){

        int temp = map.get(a); //a의 value
        int temp2 = map.get(b); //b의 value

        if(map.containsKey(a)){
            map.put(a, temp2);
			hashSet.get(temp2).add(a);
        }
        if(map.containsKey(b)){
            map.put(b, temp);
            hashSet.get(temp).add(b);
        }

        // System.out.println(map);
        // System.out.println(hashSet);

    }
}