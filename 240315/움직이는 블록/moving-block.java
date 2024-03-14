import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] arr;


	public static void main(String[] args) throws IOException{
		// 여기에 코드를 작성해주세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		int sum = 0;
		for(int i = 0; i < N; i++){
			int x = Integer.parseInt(br.readLine());
			sum += x;
			arr[i] = x;
		}
		Arrays.sort(arr);

		int avg = sum / N;
		int left = 0, right = N-1;
		int answer = 0;
		int need = 0;
		while(!allSame(avg)){

			need += avg - arr[left];
			if(arr[right] - avg >= 0){
				if(arr[right] - avg >= need){
					answer += need;
					arr[left++] += need;
					arr[right] -= need;
				} else {
					answer += arr[right] - avg;
					arr[left] += arr[right] -avg;
					arr[right--] = avg;
				}

				need = 0;
			} else {
				right--;
			}
		}
		System.out.println(answer);




	}

	public static boolean allSame(int avg){
		for(int i : arr){
			if(i != avg)
				return false;
		}
		return true;
	}
}