import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
	static int n, s;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		arr = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long sum= 0;
		int answer = n+1;
		int j = 0;

		for(int i = 0; i < n; i++){
			while(sum < s && j < n){
				sum += arr[j];
				j++;
			}
			if (sum >= s)
				answer = Math.min(answer, j - i);
			sum -= arr[i];
		}
		System.out.println(answer == n + 1 ? -1 : answer);

	}

}