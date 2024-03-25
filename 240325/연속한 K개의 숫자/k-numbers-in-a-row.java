import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int n=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());

		int[] arr=new int[n+1];
		for(int i=1;i<=n;i++){
			arr[i]=i;
		}

		for(int i=0;i<b;i++){
			arr[Integer.parseInt(br.readLine())]=0;
		}

		int count=0;//0이 아닌애들 카운트
		for(int i=1;i<=K;i++){
			if(arr[i]!=0){
				count++;
			}
		}
		int left=1;
		int right=K;

		int max=count;

		while(right!=n+1){
			max=Math.max(max,count);
			if(arr[right]!=0){
				count++;
			}
			if(arr[left]!=0){
				count--;
			}
			left++;
			right++;
		}

		System.out.println(K-max);

	}
}