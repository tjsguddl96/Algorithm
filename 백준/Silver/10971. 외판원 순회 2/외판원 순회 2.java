import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	static int ans=Integer.MAX_VALUE;
	static int[] ch;
	static int[][] dist;
	static int startIdx;
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(bf.readLine());
		
		arr=new int[n][n];
		dist=new int[n][n];
		for(int i=0;i<n;i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<n;i++) {
			ch=new int[n];
			dfs(i,i,0,0);
		}
		
		System.out.println(ans);
	}
	public static void dfs(int startIdx,int nowIdx,int nowDist,int cnt) {
		if(cnt==n-1) {
			if(arr[nowIdx][startIdx]!=0) {
				ans=Math.min(ans,nowDist+arr[nowIdx][startIdx]);
			}
			return ;
		}
		ch[nowIdx]=1;
		for(int nextIdx=0;nextIdx<n;nextIdx++) {
			if(arr[nowIdx][nextIdx]!=0 && ch[nextIdx]==0) {
				ch[nextIdx]=1;
				dfs(startIdx,nextIdx,nowDist+arr[nowIdx][nextIdx],cnt+1);
				ch[nextIdx]=0;

			}
		
		}
		
		
	}

}