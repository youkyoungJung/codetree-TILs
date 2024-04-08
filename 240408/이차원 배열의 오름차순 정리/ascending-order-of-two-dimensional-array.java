import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		arr = new int[n * n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i*n+j] = (i+1) * (j+1);
			}
		}
		Arrays.sort(arr);
		System.out.println(arr[m-1]);

	}

}