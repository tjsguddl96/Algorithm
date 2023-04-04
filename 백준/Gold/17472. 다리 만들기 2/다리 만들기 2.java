import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m; //n:행, m:열
	static int[][] board;
	static int[][] boardCh;
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,1,-1};
	static int[] parent;
	static ArrayList<bridge> b=new ArrayList<>();
	static class bridge implements Comparable<bridge>{
		int n1;
		int n2;
		int dist;
		public bridge(int n1,int n2,int dist) {
			this.n1=n1;
			this.n2=n2;
			this.dist=dist;
		}
		@Override
		public int compareTo(bridge o) {
			
			return this.dist-o.dist;
		}
	}
	static class position{
		int y;
		int x;
		public position(int y,int x) {
			this.y=y;
			this.x=x;
		}
	}
	static Queue<position> q=new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(bf.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		board=new int[n][m];
		boardCh=new int[n][m];
		for(int i=0;i<n;i++) {
			StringTokenizer st1=new StringTokenizer(bf.readLine());
			for(int j=0;j<m;j++) {
				board[i][j]=Integer.parseInt(st1.nextToken());
			}
		}
		int cnt=1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(boardCh[i][j]==0 && board[i][j]==1) {
					boardCh[i][j]=cnt;
					q.add(new position(i,j));
					bfs(cnt);
					cnt++;
				}
			}
		}
		
		parent=new int[cnt];
		for(int i=1;i<cnt;i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<n;i++) {
			int now=0;
			int flag=0;
			int dist=0;
			for(int j=0;j<m;j++) {
				
				if(boardCh[i][j]!=0 && flag==0) {
					dist=0;
					now=boardCh[i][j];
					flag=1;
				}
				else if(boardCh[i][j]==now) {
					dist=0;
				}
				else if(boardCh[i][j]==0) {
					dist++;
				}
				else if(boardCh[i][j]!=0 && boardCh[i][j]!=now) {
					if(dist<2) {
						dist=0;
						
						now=boardCh[i][j];
						continue;
					}
					
					b.add(new bridge(now, boardCh[i][j], dist));
					now=boardCh[i][j];
					dist=0;
					
					
				}
			}
		}
		for(int i=0;i<m;i++) {
			int now=0;
			int flag=0;
			int dist=0;
			for(int j=0;j<n;j++) {
				if(boardCh[j][i]!=0 && flag==0) {
					dist=0;
					now=boardCh[j][i];
					flag=1;
				}
				else if(boardCh[j][i]==now) {
					dist=0;
				}
				else if(boardCh[j][i]==0) {
					dist++;
				}
				else if(boardCh[j][i]!=0 && boardCh[j][i]!=now) {
					if(dist<2) {
						dist=0;
						now=boardCh[j][i];
						continue;
					}
					
					b.add(new bridge(now, boardCh[j][i], dist));
					now=boardCh[j][i];
					dist=0;
					
				}
			}
		}
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.print(boardCh[i][j]+" ");
//			}
//			System.out.println();
//		}
		Collections.sort(b);
//		for(int i=0;i<b.size();i++) {
//			int n1=b.get(i).n1;
//			int n2=b.get(i).n2;
//			int dist=b.get(i).dist;
//
//			System.out.println(n1+" "+n2+" "+dist);
//		}
		
		
		
		
		int answer=0;
		for(int i=0;i<b.size();i++) {
			int n1=b.get(i).n1;
			int n2=b.get(i).n2;
			int dist=b.get(i).dist;

			if(getParent(n1)!=getParent(n2)) {
				union(getParent(n1),getParent(n2));
				answer+=dist;
			}
//			System.out.println(n1+" "+n2+" "+dist);
//			System.out.println(Arrays.toString(parent));
		}
		int flag=0;
		for(int i=1;i<cnt;i++) {
			//System.out.println(i+" "+getParent(i));
			if(getParent(i)!=1) {
				flag=1;
				break;
			}
		}
		if(answer==0 || flag==1) {
			answer=-1;
		}
		
		System.out.println(answer);
		
	}
	public static void bfs(int cnt) {
		while(!q.isEmpty()) {
			position nowP=q.poll();
			int nowY=nowP.y;
			int nowX=nowP.x;
			
			for(int i=0;i<4;i++) {
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				if(nextY>=0 && nextY<n && nextX>=0 && nextX<m && boardCh[nextY][nextX]==0 && board[nextY][nextX]==1) {
					boardCh[nextY][nextX]=cnt;
					q.add(new position(nextY,nextX));
				}
			}
		}
	}
	public static int getParent(int x) {
		if(x!=parent[x]) {
			return getParent(parent[x]);
		}
		return parent[x];
	}
	public static void union(int a,int b) {
		int parentA=getParent(a);
		int parentB=getParent(b);
		if(parentA<=parentB) {
			parent[b]=parentA;
		}else {
			parent[a]=parentB;
		}
	}
	

}
/*
 2 1 4
 2 3 3
 2 4 2
 1 4 4
 
 -->
 2 4 2 // 2 2
 2 3 3 // 2 2
 2 1 4 // 1 1
 1 4 4
 
4 8
0 0 0 0 0 0 1 1
1 0 0 1 1 0 1 1
1 1 1 1 0 0 0 0
1 1 0 0 0 1 1 0
->-1
 
8 8
1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 1
1 0 0 0 0 0 0 1
1 0 0 1 1 0 0 1
1 0 0 0 0 0 0 1
1 0 0 0 0 0 0 1
1 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1
->2

2 5
1 0 0 0 0
0 0 0 1 0
->-1

6 6
1 1 1 1 1 1
0 0 0 0 0 0
1 1 1 0 1 0
0 1 0 1 0 1
0 0 0 0 0 0
1 1 1 1 1 1
->-1

5 6
1 1 0 0 0 1
1 1 0 0 0 1
0 0 0 0 0 1
0 0 0 0 0 1
1 1 1 1 1 1
->2
6 5
1 1 0 0 1
1 1 0 0 1
0 0 0 0 1
0 0 0 0 1
0 0 0 0 1
1 1 1 1 1
->2

6 10
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 1 0 0 0
1 0 1 0 1 0 1 0 0 1
1 0 1 1 1 0 1 0 0 1
0 0 0 0 0 0 0 0 0 1
1 1 0 1 1 1 1 1 0 1

3 7
1 0 0 1 0 0 1
1 0 0 1 0 0 1
1 1 1 1 0 0 0

9 6
0 0 0 0 1 0
0 0 0 0 0 0
0 1 0 0 0 1
0 0 0 0 0 0
0 0 0 0 0 0
0 1 0 0 1 1
0 0 0 0 0 0
0 0 0 0 0 0
0 1 0 0 0 0

10 10
0 0 0 1 1 0 0 0 0 0
0 0 0 1 0 0 0 0 0 1
0 0 0 1 1 0 0 0 0 0
0 0 0 1 1 0 0 0 0 0
1 0 0 1 0 0 0 0 0 1
0 0 0 1 1 0 0 0 0 0
0 0 0 1 1 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1
0 0 1 1 1 1 0 0 1 1

8 8
0 0 0 1 1 1 1 0
0 1 1 1 1 0 1 0
0 1 0 1 1 1 0 0
0 1 0 0 0 1 0 0
0 0 0 1 0 0 1 0
0 0 0 0 0 1 0 0
0 1 1 1 0 0 0 0
0 1 0 0 0 1 0 0
3 7
1 0 0 1 0 0 1
1 0 0 1 0 0 1
1 1 1 1 0 0 0
 */