import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[] combi=new int[3];
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,1,-1};
	static int[][] board;
	static int[][] copyBoard;
	static ArrayList<position> virus=new ArrayList<>();
	static int ans;
	static int size=0;
	static int[][] ch;
	static class position{
		int y;
		int x;
		public position(int y,int x) {
			this.y=y;
			this.x=x;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		n=Integer.parseInt(st.nextToken()); //행
		m=Integer.parseInt(st.nextToken()); //열
		
		board=new int[n][m];
		copyBoard=new int[n][m];
		ch=new int[n][m];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st1=new StringTokenizer(bf.readLine());
			for(int j=0;j<m;j++) {
				board[i][j]=Integer.parseInt(st1.nextToken());
				if(board[i][j]==2) {
					virus.add(new position(i,j));
				}
			}
		}
		
		com(0,0);
		System.out.println(ans);
	}
	public static int[][] copyBoard() {
		int[][] copyB=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				copyB[i][j]=board[i][j];
			}
		}
		return copyB;
	}
	
	public static void bfs() {
		Queue<position> q=new ArrayDeque<>();
		
		for(int i=0;i<virus.size();i++) {
			position p=virus.get(i);
			q.add(new position(p.y,p.x));
		}
		while(!q.isEmpty()) {
			position nowV=q.poll();
			int nowY=nowV.y;
			int nowX=nowV.x;
			ch[nowY][nowX]=1;
			for(int i=0;i<4;i++) {
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				if(nextY>=0 && nextY<n && nextX>=0 && nextX<m && copyBoard[nextY][nextX]==0 && ch[nextY][nextX]==0) {
					ch[nextY][nextX]=1;
					q.add(new position(nextY,nextX));
					copyBoard[nextY][nextX]=2;
				}
			}
		}
		
	}
	public static void com(int cnt,int start) {
		if(cnt==3) {
			int flag=0;
			ch=new int[n][m];
			copyBoard=copyBoard();
			for(int i=0;i<combi.length;i++) {
				int y=(int)combi[i]/m;
				int x=(int)combi[i]%m;
				if(board[y][x]!=0) {
					flag=1;
					break;
				}
				copyBoard[y][x]=1;
			}
			if(flag==0) {
				bfs();
				int sum=0;
				for(int i=0;i<n;i++) {
					for(int j=0;j<m;j++) {
						if(copyBoard[i][j]==0) {
							sum++;
						}
					}
				}
				ans=Math.max(ans,sum);
			}
			return ;
		}
		for(int i=start;i<(n*m);i++) {
			combi[cnt]=i;
			com(cnt+1,i+1);
		}
	}
}