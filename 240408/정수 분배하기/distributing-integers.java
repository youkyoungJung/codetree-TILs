import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

	static int[] arr;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int left = 1, right = 10001;
		int answer = 0;
		while(left <= right){
			int mid = (left + right) /2;
			if(div(mid) >= m){
				left = mid +1;
				answer = Math.max(answer, mid);
			} else{
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}

	public static int div(int x){
		int cnt = 0;
		for (int i : arr) {
			cnt += i/x;
		}
		return cnt;
	}

}