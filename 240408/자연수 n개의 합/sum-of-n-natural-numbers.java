import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

	static long s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = Long.parseLong(br.readLine());

		long left = 0, right = s, answer = 0;
		while (left <= right) {
			long mid = (left + right) / 2;
			if (mid * (mid + 1) / 2 <= s) {
				left = mid + 1;
				answer = Math.max(answer, mid);
			} else {
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}

}