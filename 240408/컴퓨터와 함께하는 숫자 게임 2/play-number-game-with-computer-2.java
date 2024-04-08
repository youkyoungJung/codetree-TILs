import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

	static long m, a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = Long.parseLong(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		int min = Integer.MAX_VALUE;
		int max = -1;

		for (long i = a; i <= b; i++) {
			int x = bs(i);
			// System.out.println("i = " + i);
			// System.out.println("x = " + x);
			min = Math.min(min, x);
			max = Math.max(max, x);
		}

		System.out.println(min + " " + max);

	}

	public static int bs(long x) {
		long left = 1, right = m;
		int cnt = 0;
		while (left <= right) {
			// System.out.println("left = " + left + " right = " + right);
			cnt++;
			long mid = (left + right) / 2;
			if (mid == x) {
				break;
			} else if (mid < x) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return cnt;
	}

}