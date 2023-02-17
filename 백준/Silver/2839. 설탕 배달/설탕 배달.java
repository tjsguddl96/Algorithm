import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] dp;
	public static void main(String[] args) throws IOException {

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(bf.readLine());
		
		dp=new int[N+1];
		
		for(int i=0;i<N+1;i++) {
			dp[i]=999999999;
		}
		if(N>=3) {
			dp[3]=1;
		}
		if(N>=5) {
			dp[5]=1;
		}
		
		for(int i=3;i<N+1;i++) {
			for(int j=3;j<i;j++) {

				if(dp[i]>dp[i-j]+dp[j]) {
					dp[i]=dp[i-j]+dp[j];
				}
			
			}
		}
		if(dp[N]==999999999) {
			System.out.println(-1);
		}
		else {
			System.out.println(dp[N]);
		}

	}

}