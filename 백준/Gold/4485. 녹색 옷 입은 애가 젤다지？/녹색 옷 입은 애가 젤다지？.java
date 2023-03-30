import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	
	static int[][] board;
	static int[][] ch;
	static PriorityQueue<position> pq;
	static ArrayList<String> answer=new ArrayList<>();
	static class position implements Comparable<position>{
		int y;
		int x;
		int value;
		public position(int y, int x,int value) {
			this.y=y;
			this.x=x;
			this.value=value;
		}
		@Override
		public int compareTo(position o) {

			return this.value-o.value;
		}
	}
	public static void main(String[] args) throws IOException {
		int tc=1;
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int n=Integer.parseInt(bf.readLine());
			if(n==0) break;
			else {
				board=new int[n][n];
				ch=new int[n][n];
				for(int i=0;i<n;i++) {
					Arrays.fill(ch[i], 9999999);
				}
				pq=new PriorityQueue<>();
				
				for(int i=0;i<n;i++) {
					StringTokenizer st1=new StringTokenizer(bf.readLine());
					for(int j=0;j<n;j++) {
						board[i][j]=Integer.parseInt(st1.nextToken());
					}
				}
					
				pq.add(new position(0,0,board[0][0]));
				bfs(n);
				String str="Problem "+tc+": "+ch[n-1][n-1];
				//System.out.println(str);
				answer.add(str);
				tc++;
			}
		}
		for(int i=0;i<answer.size();i++) {
			System.out.println(answer.get(i));
		}
		
	}
	public static void bfs(int n) {
		while(!pq.isEmpty()) {
			position nowP=pq.poll();
			int nowY=nowP.y;
			int nowX=nowP.x;
			int coin=nowP.value;
			ch[nowY][nowX]=coin;
			for(int i=0;i<4;i++) {
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				if(nextY>=0 && nextY<n &&nextX>=0 && nextX<n && ch[nextY][nextX]>coin+board[nextY][nextX]) {
					ch[nextY][nextX]=coin+board[nextY][nextX];
					pq.add(new position(nextY,nextX,coin+board[nextY][nextX]));
				}

			}
		}
	}

}