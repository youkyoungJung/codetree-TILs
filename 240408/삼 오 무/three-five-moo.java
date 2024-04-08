import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
	static long n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		long left = 0, right = Long.MAX_VALUE, answer = Long.MAX_VALUE;
		while(left <= right){
			long mid = (left + right) /2;
			if (moo(mid) >= n) {
				right = mid - 1;
				answer = Math.min(answer, mid);
			} else {
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}

	private static long moo(long mid) {
		long cnt = mid;
		cnt -= (mid / 3);
		cnt -= (mid / 5);
		cnt += (mid / 15);
		return cnt;
	}

}