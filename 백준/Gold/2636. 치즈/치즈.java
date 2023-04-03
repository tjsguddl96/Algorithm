import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
	//접촉면의 한쪽이라도 0이라면 공기 노출 but, 사이의 공기 --> 맨 가장자리랑 붙어있지 않은 0들 
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,1,-1};
	static int n,m; //n행 m열
	static int[][] board;
	static int[][] hole; //hole이 1인 애들이 공기
	static int[][] cheese;
	static class position{
		int y;
		int x;
		int dist;
		public position(int y,int x, int dist) {
			this.y=y;
			this.x=x;
			this.dist=dist;
		}
	}
	static Queue<position> holeq=new ArrayDeque<>();
	static Queue<position> cheeseq=new ArrayDeque<>();
	static Queue<position> dq=new ArrayDeque<>();
	static class ans{
		int answer;
		int size;
		public ans(int answer,int size){
			this.answer=answer;
			this.size=size;
		}
	}
	static ArrayList<ans> answ=new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		board=new int[n][m];
		
		
		for(int i=0;i<n;i++) {
			StringTokenizer st1=new StringTokenizer(bf.readLine());
			for(int j=0;j<m;j++) {
				board[i][j]=Integer.parseInt(st1.nextToken());
			}

		}
		int answer=0;
		int flag=0;
		
		while(flag==0) {
			int tmp=0;
			hole=new int[n][m]; //hole이면 1로 바꾸자
			holeq.add(new position(0,0,0));
			holeBFS();
			cheese=new int[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(board[i][j]==1) {
						tmp++;
					}
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(board[i][j]==1 && cheese[i][j]==0) {
						cheeseq.add(new position(i,j,0));
						BFS();
					}
				}
			}
			
			if(dq.size()==0) {
				flag=1;
				break;
			}
			
			while(!dq.isEmpty()) {
				position P=dq.poll();
				board[P.y][P.x]=0;
			}
			
			answer++;
			answ.add(new ans(answer,tmp));
		}
		System.out.println(answ.get(answ.size()-1).answer);
		System.out.println(answ.get(answ.size()-1).size);
	}
	public static void holeBFS() {
		while(!holeq.isEmpty()) {
			position nowP=holeq.poll();
			int nowY=nowP.y;
			int nowX=nowP.x;
			hole[nowY][nowX]=1;
			
			for(int i=0;i<4;i++) {
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				if(nextY>=0 && nextY<n && nextX>=0 && nextX<m && hole[nextY][nextX]==0 && board[nextY][nextX]==0) {
					hole[nextY][nextX]=1;
					holeq.add(new position(nextY,nextX,1));
					
				}
			}
		}
	}
	
	public static void BFS() {
		while(!cheeseq.isEmpty()) {
			position nowP=cheeseq.poll();
			int nowY=nowP.y;
			int nowX=nowP.x;
			cheese[nowY][nowX]=1;
			
		
			for(int i=0;i<4;i++) {
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				if(nextY>=0 && nextY<n && nextX>=0 && nextX<m && hole[nextY][nextX]==1) {
					dq.add(new position(nowY,nowX,0));
				}
				if(nextY>=0 && nextY<n && nextX>=0 && nextX<m && board[nextY][nextX]==1 && cheese[nextY][nextX]==0 ) {
					
					cheese[nextY][nextX]=1;
					cheeseq.add(new position(nextY,nextX,1));
					
				}
			}
		}
	}
	
}