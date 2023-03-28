import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(bf.readLine());
		int[][] arr=new int[n][3];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(bf.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int inf=9999999;
		int answer=inf;

		for(int i=0;i<3;i++) {
			int[][] dp=new int[n][3]; //dp[i번째 집][r,g,b]
			for(int j=0;j<n;j++) {
				Arrays.fill(dp[j], inf);
			}
			dp[0][i]=arr[0][i]; //첫번째 집 r,g,b 중 칠함
			for(int j=1;j<n;j++) {
				dp[j][0]=arr[j][0]+Math.min(dp[j-1][1], dp[j-1][2]); //현재 집의 색을 제외한 이전 집의 색 중 작은 값을 합해서 dp에 저장
				dp[j][1]=arr[j][1]+Math.min(dp[j-1][0], dp[j-1][2]); 
				dp[j][2]=arr[j][2]+Math.min(dp[j-1][1], dp[j-1][0]); 
			}
			for(int j=0;j<3;j++) {
				answer=Math.min(answer, dp[n-1][j]);

			}
			
		}
		System.out.println(answer);
	}
}