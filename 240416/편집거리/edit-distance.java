import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String first=br.readLine();
		String second=br.readLine();

		int n=first.length();
		int m=second.length();

		int[][] dp=new int[n+1][m+1];

		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(first.charAt(i-1)==second.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
				} else{
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}

		System.out.println(dp[n][m]);
	}
}