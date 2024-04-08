import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
	static int n, s;
	static int[] arr;
	static int[] cnts;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			max = Math.max(max, x);
			arr[i] = x;
		}
		cnts = new int[max + 1];

		int j = 0;
		int answer = -1;
		for (int i = 0; i < n; i++) {
			while (j < n && cnts[arr[j]] != 1) {
				cnts[arr[j]]++;
				j++;
			}
			answer = Math.max(answer, j-i);
			cnts[arr[i]]--;
		}
		System.out.println(answer);
	}

}