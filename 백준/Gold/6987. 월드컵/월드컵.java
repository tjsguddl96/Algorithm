import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] answer= {0,0,0,0};
	static int[][] matchCase;
	static int[][] result;
	static int[][] match;
	static int ans;
	public static void main(String[] args) throws IOException {

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		matchCase=new int[15][2];
		
		makeCase();
		
		for(int i=0;i<4;i++) {
			match=new int[6][3];
			
			StringTokenizer st=new StringTokenizer(bf.readLine());
			ans=0;
			
			for(int k=0;k<6;k++) {
				for(int j=0;j<3;j++) {
					match[k][j]=Integer.parseInt(st.nextToken());
				}	
			}
			result=new int[6][3];
			solve(0);
			answer[i]=ans;
			
		}
		for(int i=0;i<4;i++) {
			System.out.print(answer[i]+" ");
		}
		
	}
	public static void makeCase() {
		int idx=0;
		for(int i=0;i<5;i++) {
			for(int j=i+1;j<6;j++) {
				matchCase[idx][0]=i;
				matchCase[idx][1]=j;
				idx++;
			}
			
		}
	}
	
	public static void solve(int played) {
		if(played==15) {
			if(ans==1) return ;
			for(int i=0;i<6;i++) {
				for(int j=0;j<3;j++) {
					if(result[i][j]!=match[i][j]) {
						ans=0;
						return ;
					}
				}
			}
			ans=1;
			return ;
		}
		
		int team1=matchCase[played][0];
		int team2=matchCase[played][1];
		
		//team1 승 team2 패
		result[team1][0]++;
		result[team2][2]++;
		solve(played+1);
		result[team1][0]--;
		result[team2][2]--;
		
		//무승부
		result[team1][1]++;
		result[team2][1]++;
		solve(played+1);
		result[team1][1]--;
		result[team2][1]--;
		
		//team1 패 team2 승
		result[team1][2]++;
		result[team2][0]++;
		solve(played+1);
		result[team1][2]--;
		result[team2][0]--;
		
	}
	
}
