import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int N;
	static char[][] map;
	static int[][][] ch;
	static class position{
		int y;
		int x;
		public position(int y,int x) {
			this.y=y;
			this.x=x;
		}
		@Override
		public String toString() {
			return y+","+x;
		}
	}
	static class poll{
		position p1;
		position p2;
		position p3;
		int dir; //1이면 세로, 0이면 가로
		int cnt;
		public poll(position p1,position p2,position p3,int dir,int cnt) {
			this.p1=p1;
			this.p2=p2;
			this.p3=p3;
			this.dir=dir;
			this.cnt=cnt;
		}
		@Override
		public String toString() {
			return p1.toString()+"/"+p2.toString()+"/"+p3.toString();
		}
	}
	static poll dst;
	static poll p;
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,1,-1};
	static Deque<poll> q=new ArrayDeque<>();
	static int ans=9999999;
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		map=new char[N][N];
		ch=new int[N][N][2];
		int tmpIdx1=0;
		int tmpIdx2=0;
		position[] posi1=new position[3];
		position[] posi2=new position[3];
		
		for(int i=0;i<N;i++) {
			String str=bf.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='B') {
					posi1[tmpIdx1]=new position(i,j);
					tmpIdx1++;
				}else if(map[i][j]=='E') {
					posi2[tmpIdx2]=new position(i,j);
					tmpIdx2++;
				}
			}
		}
		
		if(posi1[0].y==posi1[1].y && posi1[0].x!=posi1[1].x) { //가로
			p=new poll(posi1[0],posi1[1],posi1[2],0,0);
		}else {
			p=new poll(posi1[0],posi1[1],posi1[2],1,0);
		}
		
		if(posi2[0].y==posi2[1].y && posi2[0].x!=posi2[1].x) { //가로
			dst=new poll(posi2[0],posi2[1],posi2[2],0,0);
		}else {
			dst=new poll(posi2[0],posi2[1],posi2[2],1,0);
		}
		q.add(p);
		bfs();
		if(ans==9999999) {
			ans=0;
		}
		System.out.println(ans);
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			poll now=q.poll();
//			System.out.println(now.toString());
			int nowY1=now.p1.y;
			int nowY2=now.p2.y;
			int nowY3=now.p3.y;
			
			int nowX1=now.p1.x;
			int nowX2=now.p2.x;
			int nowX3=now.p3.x;
			
			int nowD=now.dir;
			int nowCnt=now.cnt;
			ch[nowY2][nowX2][nowD]=1;
			if(nowY2==dst.p2.y && nowX2==dst.p2.x && ((nowY1==dst.p1.y && nowX1==dst.p1.x)||(nowY3==dst.p1.y && nowX3==dst.p1.x)) &&((nowY1==dst.p3.y && nowX1==dst.p3.x)||(nowY3==dst.p3.y && nowX3==dst.p3.x)) ) {
				ans=Math.min(ans, nowCnt);
				return ;
			}
			
			
			for(int i=0;i<4;i++) {//상하좌우 움직
				int nextY1=nowY1+dy[i];
				int nextY2=nowY2+dy[i];
				int nextY3=nowY3+dy[i];
				
				int nextX1=nowX1+dx[i];
				int nextX2=nowX2+dx[i];
				int nextX3=nowX3+dx[i];
				
				int nextCnt=nowCnt+1;
				
				if(check(nextY1,nextX1) && check(nextY2,nextX2) && check(nextY3,nextX3) && ch[nextY2][nextX2][nowD]==0) {
					ch[nextY2][nextX2][nowD]=1;
					q.add(new poll(new position(nextY1,nextX1),new position(nextY2,nextX2),new position(nextY3,nextX3),nowD,nextCnt));
				}
				
			}
			//turn
			//가로 일때 (nowD==0)
			if(nowD==0) {
				int nextY1=nowY2+1;
				int nextY3=nowY2-1;
				int nextX1=nowX2;
				int nextX3=nowX2;
				int nextD=1;
				int nextCnt=nowCnt+1;
				
				if(check(nextY1,nextX1) && check(nextY3,nextX3) && check2(nowY2,nowX2)&&ch[nowY2][nowX2][nextD]==0) {
					ch[nowY2][nowX2][nextD]=1;
					q.add(new poll(new position(nextY1,nextX1),new position(nowY2,nowX2),new position(nextY3,nextX3),nextD,nextCnt));
				}
			}
			else {
				int nextY1=nowY2;
				int nextY3=nowY2;
				int nextX1=nowX2-1;
				int nextX3=nowX2+1;
				int nextD=0;
				int nextCnt=nowCnt+1;
				
				if(check(nextY1,nextX1) && check(nextY3,nextX3) && check2(nowY2,nowX2)&&ch[nowY2][nowX2][nextD]==0) {
					ch[nowY2][nowX2][nextD]=1;
					q.add(new poll(new position(nextY1,nextX1),new position(nowY2,nowX2),new position(nextY3,nextX3),nextD,nextCnt));
				}
			}
			
		}
	}
	public static boolean check2(int y,int x) {
		if(y<=0 || x<=0 || y>=N-1 || x>=N-1) {
			return false;
		}
		for(int i=y-1;i<=y+1;i++) {
			for(int j=x-1;j<=x+1;j++) {
				if(map[i][j]=='1') {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean check(int y,int x) {
		if(y>=0 && y<N && x>=0 && x<N && map[y][x]!='1') {
			return true;
		}
		return false;
	}
}