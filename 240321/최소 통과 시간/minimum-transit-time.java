import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] ternel;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());

		ternel = new int[m];
		int maxTime=0;
		for(int i=0;i<m;i++){
			ternel[i]=Integer.parseInt(br.readLine());
			maxTime=Math.max(maxTime,ternel[i]);
		}
		Arrays.sort(ternel);

		long left=-1;
		long right=maxTime*n;

		long mid=0;
		while(left+1<right){
			mid=(left+right)>>1;
			if(check(mid,n)){
				right=mid;
			}else{
				left=mid;
			}
		}
		System.out.println(right);


	}

	private static boolean check(long mid,int n) {
		long count=0;
		for(int i=0;i<ternel.length;i++){
			count+=mid/ternel[i];
			if(mid/ternel[i]==0){
				return count>=n;
			}
		}
		return count>=n;
	}
}