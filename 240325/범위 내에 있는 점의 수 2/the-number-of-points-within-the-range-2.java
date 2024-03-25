import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());

		int[] arr=new int[1000001];

		st=new StringTokenizer(br.readLine());

		for(int i=0;i<n;i++){
			arr[Integer.parseInt(st.nextToken())]=1;
		}
		for(int i=1;i<1000001;i++){
			arr[i]=arr[i-1]+arr[i];
		}

		StringBuilder sb=new StringBuilder();
		for(int i=0;i<q;i++){
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());

			sb.append(arr[b]-arr[a-1]).append('\n');
		}//입력 종료

		System.out.println(sb);
	}
}