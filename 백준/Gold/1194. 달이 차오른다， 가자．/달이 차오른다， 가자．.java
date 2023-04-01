import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
// a:97 열쇠, A:65 문, .:46 빈칸, #:벽 35,1:도착, 0:출발
public class Main {
	static int n,m; //n:행, m:열
	static char[][] board;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	static Queue<position> q=new ArrayDeque<>();
	static int[][][] ch;
	static int ans=99999999;
	static class position{
		int y;
		int x;
		int dist;
		int key;
		public position(int y, int x,int dist,int key) {
			this.y=y;
			this.x=x;
			this.dist=dist;
			this.key=key;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		board=new char[n][m];
		ch=new int[n][m][64];
		
		for(int i=0;i<n;i++) {
			String str=bf.readLine();
			for(int j=0;j<m;j++) {
				board[i][j]=str.charAt(j);
				if(board[i][j]=='0') {
					q.add(new position(i,j,0,0));
				}
			}
		
		}
		
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
			int nowK=nowP.key;
			
			
			
			if(board[nowY][nowX]=='1') {
				
				ans=Math.min(ans, nowD);
			}
			
			for(int i=0;i<4;i++) {
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				int nextD=nowD+1;
				if(nextY>=0 && nextY<n && nextX>=0 && nextX<m && board[nextY][nextX]!='#' && ch[nextY][nextX][nowK]==0) {
					if(board[nextY][nextX]=='.' || board[nextY][nextX]=='1' || (int)board[nextY][nextX]>=97 || board[nextY][nextX]=='0') {
						int nextK=0;
						if((int)board[nextY][nextX]>=97) {//키 일때, 
							nextK=nowK|(1<<(102-(int)board[nextY][nextX]));
							
							q.add(new position(nextY,nextX,nextD,nextK));
							ch[nextY][nextX][nextK]=1;
							ch[nextY][nextX][nowK]=1;
							
						}
						else {
							q.add(new position(nextY,nextX,nextD,nowK));
							ch[nextY][nextX][nowK]=1;
						}
						
					}else { //문 일때 
						int temp=nowK&(1<<(70-(int)board[nextY][nextX]));
						if(temp==0) {//해당 문에 있는 키가 없을 때 진행X
							continue;
						}
						ch[nextY][nextX][nowK]=1;
						

						q.add(new position(nextY,nextX,nextD,nowK));
						
					}
				}
			}
			
		}
	}
	
}