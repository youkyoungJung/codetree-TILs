import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static boolean[] live, wifi;


	public static void main(String[] args) throws IOException{
		// 여기에 코드를 작성해주세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		live = new boolean[n+1];
		wifi = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i =1;i <= n ;i++){
			int x = Integer.parseInt(st.nextToken());
			if(x == 1){
				live[i] = true;
			} else {
				live[i] = false;
			}
		}
		int answer =0;

		while(!allWifi()){
			answer++;
			int max = 0;
			int idx = 1;
			for(int i = 1; i <=n; i++){
				int cnt = 0;
				for(int j = Math.max(1, i-m); j <= Math.min(n, i+m); j++){
					if(live[j] && !wifi[j])
						cnt++;
				}
				if(max <= cnt){
					max = cnt;
					idx = i;
				}
			}
			for(int j = Math.max(1, idx-m); j <= Math.min(n, idx+m); j++){
				if(live[j])
					wifi[j] = true;
			}
		}

		System.out.println(answer);

	}

	public static boolean allWifi(){
		for(int i =1; i <= n; i++){
			if(live[i]){
				if(!wifi[i])
					return false;
			}
		}
		return true;
	}




}