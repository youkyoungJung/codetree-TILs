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
			arr[i] = max;
		}
		cnts = new int[max + 1];

		int j = 0;
		int answer = -1;
		for (int i = 0; i < n; i++) {
			while (possible() && j < n) {
				cnts[arr[j]]++;
				j++;
			}
			answer = Math.max(answer, j-i);
			arr[i] -= 1;
		}
		System.out.println(answer);
	}

	public static boolean possible() {
		for (int i = 0; i < cnts.length; i++) {
			if(cnts[i] >= 2)
				return false;
		}
		return true;
	}

}