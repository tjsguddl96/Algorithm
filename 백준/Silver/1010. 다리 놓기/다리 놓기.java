import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static int N,M;
	static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(bf.readLine());
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st=new StringTokenizer(bf.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			ans=0;
			dp=new int[M+1][N+1];


			
			for(int i=0;i<=M;i++) {
				for(int j=0;j<=Math.min(i, N);j++) {
					if(j==0 || i==j) {
						dp[i][j]=1;
					}else {
						//nCr=n-1Cr-1+n-1Cr
						dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
					}
					
				}
	
			}
			ans=dp[M][N];
			System.out.println(ans);
	
		}
	}
	
}