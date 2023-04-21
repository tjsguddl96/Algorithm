import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class position{
		int y;
		int x;
		public position(int y,int x) {
			this.y=y;
			this.x=x;
		}
	}
	static int r,c,n;
	static char[][] map;
	static int[][] ch;
	static int[][] init;
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,1,-1};
	static Queue<position> q=new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		map=new char[r][c];
		ch=new int[r][c];
		ArrayList<int[][]> init=new ArrayList<>();
		for(int i=0;i<r;i++) {
			String str=bf.readLine();
			for(int j=0;j<c;j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='O') {
					ch[i][j]+=2;
				}
			}
		}
		init.add(ch);
		int time=2;
		int tmp=0;
		while(time<=n) {
			
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					ch[i][j]+=1;
					if(ch[i][j]>=4) {
						ch[i][j]=0;
						q.add(new position(i,j));
					}
				}
			}
			while(!q.isEmpty()) {
				position now=q.poll();
				int nowY=now.y;
				int nowX=now.x;
				for(int i=0;i<4;i++) {
					int nextY=nowY+dy[i];
					int nextX=nowX+dx[i];
					if(nextY>=0 && nextY<r && nextX>=0 && nextX<c) {
						ch[nextY][nextX]=0;
					}
				}
			}
			int flag=0;
			if(time>3) {
				for(int k=0;k<init.size();k++) {
					int[][] temp=init.get(k);
					for(int i=0;i<temp.length;i++) {
						for(int j=0;j<temp[i].length;j++) {
							flag=1;
							if(ch[i][j]!=temp[i][j]) {
								flag=2;
								break;
							}
						}
						if(flag==2) {
							break;
						}
					}
					if(flag==2) {
						break;
					}
				}
			}
			init.add(ch);
			if(flag==1) {
				tmp=time;
				break;
			}
//			System.out.println(time);
//			for(int i=0;i<r;i++) {
//				for(int j=0;j<c;j++) {
//					System.out.print(ch[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("-------------");
			
			time++;
		}
		time=0;
		//System.out.println("tmp "+tmp);
		q=new ArrayDeque<>();
		
		while(tmp!=0 && time<(n%tmp)) {
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					ch[i][j]+=1;
					if(ch[i][j]>=4) {
						ch[i][j]=0;
						q.add(new position(i,j));
					}
				}
			}
			while(!q.isEmpty()) {
				position now=q.poll();
				int nowY=now.y;
				int nowX=now.x;
				for(int i=0;i<4;i++) {
					int nextY=nowY+dy[i];
					int nextX=nowX+dx[i];
					if(nextY>=0 && nextY<r && nextX>=0 && nextX<c) {
						ch[nextY][nextX]=0;
					}
				}
			}
			time++;
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(ch[i][j]>0) {
					System.out.print('O');
				}
				else {
					System.out.print('.');
				}
			}
			System.out.println();
		}
		
	}

}