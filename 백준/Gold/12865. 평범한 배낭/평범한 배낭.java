import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		int[][] arr=new int[n+1][2]; //arr[i][0] : 물건 무게, arr[i][1] : 물건 가치
		int[][] dp=new int[n+1][k+1];
		
		
		for(int i=1;i<n+1;i++) {
			StringTokenizer st1=new StringTokenizer(bf.readLine());
			for(int j=0;j<2;j++) {
				arr[i][j]=Integer.parseInt(st1.nextToken());
			}
			
		}

		int maxx=0;
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<k+1;j++) {
				if(arr[i][0]<=j) { //넣을수 있는 경우
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-arr[i][0]]+arr[i][1]);
				}
				else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		System.out.println(dp[n][k]);
		
		
	}

}