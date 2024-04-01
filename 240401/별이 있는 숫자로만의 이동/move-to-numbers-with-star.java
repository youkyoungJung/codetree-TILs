import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());

		int[][] map=new int[n][n];
		int[][]sum=new int[n][n];
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
				if(j==0){
					sum[i][j]=map[i][j];
				}else{
					sum[i][j]=map[i][j]+sum[i][j-1];
				}
			}
		}//입력 종료

		int max=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				max=Math.max(max,getSum(i,j,sum,k,n));
			}
		}

		System.out.println(max);


	}//end of main

	private static int getSum(int y, int x, int[][] sum, int k, int n) {
		int curSum=0;
		for(int i=-k;i<=k;i++){
			if(y+i<0||y+i>=n)
				continue;
			int firstX=x+Math.abs(k-Math.abs(i));
			int secondX=x-Math.abs(k-Math.abs(i))-1;
			if(firstX>=n){
				firstX=n-1;
			}
			if(secondX<0){
				curSum+=sum[y+i][firstX];
				continue;
			}

			curSum+=sum[y+i][firstX]-sum[y+i][secondX];
		}
		//System.out.println("X="+x+" Y="+y+" curSum="+ curSum);
		return curSum;
	}
}