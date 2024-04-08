import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int x = Integer.parseInt(st.nextToken());
			int l = lower(x);
			int u = upper(x);
			sb.append(u-l == 0 ? -1 : l +1).append("\n");
		}

		System.out.println(sb);


	}

	private static int lower(int x){
		int left = 0, right = n;
		while(left < right){
			int mid = (left + right) / 2;
			if(arr[mid] < x){
				left = mid+1;
			} else {
				right = mid;
			}
		}
		return right;
	}

	private static int upper(int x){
		int left = 0, right = n;
		while(left < right){
			int mid = (left + right) / 2;
			if(arr[mid] <= x){
				left = mid+1;
			} else {
				right = mid;
			}
		}
		return right;
	}

}