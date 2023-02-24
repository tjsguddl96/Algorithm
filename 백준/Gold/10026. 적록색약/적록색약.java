import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
public class Main {
	static int n;
	static char[][] arr;
	static int[][] ch;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static int ans1;
	static int ans2;
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
		n=Integer.parseInt(bf.readLine());
		arr=new char[n][n];
		ch=new int[n][n];
		for(int i=0;i<n;i++) {
			String str=bf.readLine();
			for(int j=0;j<n;j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(ch[i][j]==0) {
					bfs1(i,j);
					ans1++;
				}
			}
		}
		ch=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(ch[i][j]==0) {
					bfs2(i,j);
					ans2++;
				}
			}
		}
		System.out.println(ans1+" "+ans2);
		
	}
	public static void bfs1(int y,int x) {
		Queue<position> q=new ArrayDeque<>();
		q.offer(new position(y,x));
		ch[y][x]=1;
		while(!q.isEmpty()) {
			int nowY=q.peek().y;
			int nowX=q.peek().x;
			q.poll();
			ch[nowY][nowX]=1;
			for(int i=0;i<4;i++) {
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				if(nextY>=0 && nextY<n && nextX>=0 && nextX<n && ch[nextY][nextX]==0 && arr[nowY][nowX]==arr[nextY][nextX]) {
					ch[nextY][nextX]=1;
					q.offer(new position(nextY,nextX));
					
				}
			}
		}
		
	}
	
	public static void bfs2(int y,int x) {
		Queue<position> q=new ArrayDeque<>();
		q.offer(new position(y,x));
		ch[y][x]=1;
		while(!q.isEmpty()) {
			int nowY=q.peek().y;
			int nowX=q.peek().x;
			q.poll();
			ch[nowY][nowX]=1;
			for(int i=0;i<4;i++) {
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				if(nextY>=0 && nextY<n && nextX>=0 && nextX<n && ch[nextY][nextX]==0 && check(arr[nowY][nowX],arr[nextY][nextX])) {
					ch[nextY][nextX]=1;
					q.offer(new position(nextY,nextX));
					
				}
			}
		}
		
	}
	public static boolean check(char a,char b) {
		if(a!=b) {
			if((a=='R' && b=='G')|| (a=='G' && b=='R')) {
				return true;
			}
			else {
				return false;
			}
		}
		return true;
	}

}