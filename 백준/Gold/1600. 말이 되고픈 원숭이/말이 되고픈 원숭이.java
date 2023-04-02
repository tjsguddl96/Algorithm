import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int n,m; //n: 열, m: 행 
	static int[][] board;
	static int[][][] ch;
	static int ans=99999999;
	static int[] dy= {1,-1,0,0,-2,-1,-2,-1,1,2,1,2}; //말이 이동하는 거 4부터 
	static int[] dx= {0,0,1,-1,-1,-2,1,2,-2,-1,2,1};
	static class position{
		int y;
		int x;
		int dist;
		int horse;
		public position(int y, int x, int dist,int horse) {
			this.y=y;
			this.x=x;
			this.dist=dist;
			this.horse=horse;
		}
		@Override
		public String toString() {
			return "position [y=" + y + ", x=" + x + ", dist=" + dist + ", horse=" + horse + "]";
		}
		
	}
	static Queue<position> q=new ArrayDeque<>();
	public static void main(String[] args) throws IOException{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		k=Integer.parseInt(bf.readLine());
		StringTokenizer st=new StringTokenizer(bf.readLine());
		n=Integer.parseInt(st.nextToken()); //열 
		m=Integer.parseInt(st.nextToken()); //행
		board=new int[m][n];
		ch=new int[m][n][k+1];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				Arrays.fill(ch[i][j], 999999999);
			}
		}
		for(int i=0;i<m;i++) {
			StringTokenizer st1=new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				board[i][j]=Integer.parseInt(st1.nextToken());
			}
		}
		q.add(new position(0,0,0,0));
		ch[0][0][0]=1;
		bfs();
		if(ans==99999999) {
			ans=-1;
		}
		System.out.println(ans);
		
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			position nowP=q.poll();
			int nowY=nowP.y;
			int nowX=nowP.x;
			int nowD=nowP.dist;
			int nowH=nowP.horse;
			//System.out.println(nowP.toString());
			
			if(nowY==(m-1) && nowX==(n-1)) {
				ans=nowD;
				return ;
			}
			for(int i=0;i<dy.length;i++) {
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				int nextD=nowD+1;
				int nextH=nowH;
				if(i>3) {
					nextH+=1;
					if(nextY>=0 && nextY<m && nextX>=0 && nextX<n && nextH<=k && ch[nextY][nextX][nextH]>nextD && board[nextY][nextX]==0) {
						ch[nextY][nextX][nextH]=nextD;
						q.add(new position(nextY,nextX,nextD,nextH));

					}
				}
				else{
					if(nextY>=0 && nextY<m && nextX>=0 && nextX<n && ch[nextY][nextX][nextH]>nextD && board[nextY][nextX]==0) {
						
						ch[nextY][nextX][nextH]=nextD;
						q.add(new position(nextY,nextX,nextD,nextH));
	
					}
				}
				
			}
		}
	}

}