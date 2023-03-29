import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] board;
	static int ans=0;
	static int[] dy1= {0,1}; //가로
	static int[] dx1= {1,1}; //가로
	static int[] dy2= {0,1,1}; //대각선
	static int[] dx2= {1,1,0}; //대각선
	static int[] dy3= {1,1}; //세로
	static int[] dx3= {0,1}; //세로
	
	static class position{
		int y;
		int x;
		public position(int y,int x) {
			this.y=y;
			this.x=x;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(bf.readLine());
		board=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st=new StringTokenizer(bf.readLine());
			for(int j=1;j<=n;j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		position p1=new position(1,1);
		position p2=new position(1,2);
		
		DFS(p1,p2);
		System.out.println(ans);
		
	}
	
	static public void DFS(position p1,position p2) {
		if((p1.x==n && p1.y==n)||(p2.x==n && p2.y==n)) {
			ans++;
			return ;
		}
		int dir=direc(p1,p2);
		//System.out.println(p1.y+", "+p1.x+" : "+p2.y+", "+p2.x+" :: "+dir);
		//System.exit(0);
		if(dir==1) {
			for(int i=0;i<dy1.length;i++) {
				int nextY1=p2.y;
				int nextX1=p2.x;
				int nextY2=p2.y+dy1[i];
				int nextX2=p2.x+dx1[i];
				if(nextY2>0 && nextY2<n+1 &&nextX2>0 && nextX2<n+1 && board[nextY2][nextX2]==0) {
					if(dy1[i]==1 && dx1[i]==1) {
						if(board[nextY2][nextX2-1]==0 && board[nextY2-1][nextX2]==0 ) {
							DFS(new position(nextY1,nextX1),new position(nextY2,nextX2));
						}
					}
						
					else{
						DFS(new position(nextY1,nextX1),new position(nextY2,nextX2));
					}
					
				}
			}
		}
		else if(dir==2) {
			for(int i=0;i<dy3.length;i++) {
				int nextY1=p2.y;
				int nextX1=p2.x;
				int nextY2=p2.y+dy3[i];
				int nextX2=p2.x+dx3[i];
				if(nextY2>0 && nextY2<n+1 &&nextX2>0 && nextX2<n+1 && board[nextY2][nextX2]==0) {
					if(dy3[i]==1 && dx3[i]==1) {
						if(board[nextY2][nextX2-1]==0 && board[nextY2-1][nextX2]==0 ) {
							DFS(new position(nextY1,nextX1),new position(nextY2,nextX2));
						}
					}
					else {
						DFS(new position(nextY1,nextX1),new position(nextY2,nextX2));
					}
					
				}
			}
		}
		
		else {
			for(int i=0;i<dy2.length;i++) {
				int nextY1=p2.y;
				int nextX1=p2.x;
				int nextY2=p2.y+dy2[i];
				int nextX2=p2.x+dx2[i];
				if(nextY2>0 && nextY2<n+1 &&nextX2>0 && nextX2<n+1 && board[nextY2][nextX2]==0) {
					if(dy2[i]==1 && dx2[i]==1) {
						if(board[nextY2][nextX2-1]==0 && board[nextY2-1][nextX2]==0 ) {
							DFS(new position(nextY1,nextX1),new position(nextY2,nextX2));
						}
					}
					else {
						DFS(new position(nextY1,nextX1),new position(nextY2,nextX2));
					}
					
				}
			}
		}
		
	
	}
	static public int direc(position p1,position p2) {
		if(p1.x!=p2.x && p1.y==p2.y) {
			return 1; //1이면 가로
		}
		else if(p1.x==p2.x && p1.y!=p2.y) {
			return 2; //2이면 세로
		}
		
		return 3; //3이면 대각선
		
	}

}