import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.codetree.ai/missions/8/problems/maximum-distance-point/description
public class Main {
	static int[] arr;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for(int i=0;i<N;i++){
			arr[i]=Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		int left=0;
		int right=arr[N-1]+1;

		while(left+1<right){
			int mid=(left+right)>>1;

			if(check(mid)>M){//설치해야하는 애들이 더 많으면 간격을 늘려야함
				left=mid;
			}else{
				right=mid;
			}
		}

		System.out.println(left);

	}

	private static int check(int mid) {//true면 간격을 늘림
		int before=0;
		int count=1;
		for(int i=1;i<N;i++){
			if(arr[i]-arr[before]<mid){
				continue;
			}
			count++;
			if(arr[i]-arr[before]==mid){
				before=i;
				continue;
			}
			if(arr[i]-arr[i-1]>mid){
				before=i;
				count++;
				continue;
			}
			before=i-1;
			i--;
		}

		return count;
	}
}