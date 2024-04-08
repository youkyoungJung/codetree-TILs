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
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int x = Integer.parseInt(br.readLine());
			sb.append(bs(x)).append("\n");
		}

		System.out.println(sb);


	}

	public static int bs(int x){
		int left = 0, right = n-1;
		while(left <= right){
			int mid = (left + right) / 2;
			if(arr[mid] == x){
				return mid+1;
			}
			else if(arr[mid] > x){
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		return -1;
	}

}