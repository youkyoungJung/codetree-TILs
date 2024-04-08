import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int left = 0, right = Integer.MAX_VALUE, answer = Integer.MAX_VALUE;
		while(left <= right){
			int mid = (left + right) /2;
			if (moo(mid) >= n) {
				right = mid - 1;
				answer = Math.min(answer, mid);
			} else {
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}

	private static int moo(int mid) {
		int cnt = mid;
		cnt -= (mid / 3);
		cnt -= (mid / 5);
		cnt += (mid / 15);
		return cnt;
	}

}