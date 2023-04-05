import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,1,-1};
	static int r,c; //r행 c열
	static char[][] board;
	static int[][] hedgeCh;
	static Queue<position> water;
	static Queue<position> hedge;
	static position home;
	static class position{
		int y;
		int x;
		int dist;

		public position(int y,int x,int dist) {
			this.y=y;
			this.x=x;
			this.dist=dist;
		}
	}
	static int answer=-1;
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		board=new char[r][c];
		water=new ArrayDeque<>();
		hedge=new ArrayDeque<>();
		for(int i=0;i<r;i++) {
			String str=bf.readLine();
			for(int j=0;j<c;j++) {
				board[i][j]=str.charAt(j);
				if(board[i][j]=='S') { //고슴도치 초기 위치
					hedge.add(new position(i,j,0));
				}
				else if(board[i][j]=='*') { //물 위치
					water.add(new position(i,j,0));
				}
				else if(board[i][j]=='D') {
					home=new position(i,j,0); 
				}
			} 
			
		}

		bfs();
		if(answer==-1) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(answer);
		}
	}
	public static void bfs() {
		while(!hedge.isEmpty()) {
			if(!water.isEmpty()) {
				position nowWater=water.poll();
				int nowWY=nowWater.y;
				int nowWX=nowWater.x;
				int nowWD=nowWater.dist;
				
				
				for(int i=0;i<4;i++) {
					int nextWY=nowWY+dy[i];
					int nextWX=nowWX+dx[i];
					int nextWD=nowWD+1;
					if(nextWY>=0 && nextWY<r &&nextWX>=0 && nextWX<c && board[nextWY][nextWX]!='D' && board[nextWY][nextWX]!='*'  && board[nextWY][nextWX]!='X') {
						board[nextWY][nextWX]='*';
						water.add(new position(nextWY,nextWX,nextWD));
					}
				}
				while(water.size()>0 && water.peek().dist==nowWD) {
					nowWater=water.poll();
					nowWY=nowWater.y;
					nowWX=nowWater.x;
	
					for(int i=0;i<4;i++) {
						int nextWY=nowWY+dy[i];
						int nextWX=nowWX+dx[i];
						int nextWD=nowWD+1;
						if(nextWY>=0 && nextWY<r &&nextWX>=0 && nextWX<c && board[nextWY][nextWX]!='D' && board[nextWY][nextWX]!='*'  && board[nextWY][nextWX]!='X') {
							board[nextWY][nextWX]='*';
							water.add(new position(nextWY,nextWX,nextWD));
						}
					}
				}
			//	System.out.println(water.size()+"!!!!!");
			}
//			System.out.println("###############");
//			print();
			//System.out.println(water.size()+"!!!!!");
			position nowHedge=hedge.poll();
			int nowY=nowHedge.y;
			int nowX=nowHedge.x;
			int nowD=nowHedge.dist;
			
			for(int i=0;i<4;i++) {
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				int nextD=nowD+1;
				if(nextY>=0 && nextY<r && nextX>=0 && nextX<c && board[nextY][nextX]!='S' && board[nextY][nextX]!='*' && board[nextY][nextX]!='X') {
					if(board[nextY][nextX]=='D') {
						answer=nextD;
						return ;
					}
					board[nextY][nextX]='S';
					
					hedge.add(new position(nextY,nextX,nextD));
				}
					
			}
			while(hedge.size()>0 && hedge.peek().dist==nowD) {
				nowHedge=hedge.poll();
				nowY=nowHedge.y;
				nowX=nowHedge.x;
				nowD=nowHedge.dist;

				for(int i=0;i<4;i++) {
					int nextY=nowY+dy[i];
					int nextX=nowX+dx[i];
					int nextD=nowD+1;
					if(nextY>=0 && nextY<r && nextX>=0 && nextX<c && board[nextY][nextX]!='S' && board[nextY][nextX]!='*' && board[nextY][nextX]!='X') {
						if(board[nextY][nextX]=='D') {
							answer=nextD;
							return ;
						}
						board[nextY][nextX]='S';
						
						hedge.add(new position(nextY,nextX,nextD));
					}
						
				}
			}
//			print();
			
		}
	}
	public static void print() {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}
}

/*
3 3
S..
.D.
...
-->2

5 7
S....X*
.XXX.X.
..X..X.
X.X.XX.
X...DX.
*/