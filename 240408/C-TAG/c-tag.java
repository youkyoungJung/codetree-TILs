import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> num = new ArrayList<>(3);
    static ArrayList<String> A; // 문자 그룹A
    static ArrayList<String> B; // 문자 그룹 B


    static int n;
    static int m;

    static int res = 0;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        A = new ArrayList<>();
        for(int i = 0; i < n; i++){
            A.add(br.readLine());
        }
        B = new ArrayList<>();
        for(int i = 0; i < n; i++){
            B.add(br.readLine());
        }

        select(0, 0);
        // System.out.println(b.size());
        System.out.println(res);
    }
    public static void select(int cnt, int index){
        //기저조건
        if(cnt == 3){
            // 여기서 A, B 확인
            // System.out.println(num);
            res += goCheck();
            return;
        }

        if(index == m)
            return;

        num.add(index);
        select(cnt+1, index+1);

        num.remove(num.size()-1);
        select(cnt, index+1);
    }


    public static int goCheck(){
        HashSet<String> a = new HashSet<>(); // A 그룹 조합으로 이루어진 KEY

        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < 3; j++) {
                sb.append(A.get(i).charAt(num.get(j)));
            }
            a.add(sb.toString());
        }
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < 3; j++) {
                sb.append(B.get(i).charAt(num.get(j)));
            }
            if(a.contains(sb.toString())){
                return 0;
            }
        }
        // System.out.println(num);
		return 1;
    }
}