import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static int answer;
	static char[][] arr;
	static int[][] ch;
	static int[] dx= {1,1,1};
	static int[] dy= {-1,0,1};
	static int flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		arr=new char[R][C];
		ch=new int[R][C];
		for(int i=0;i<R;i++) {
			StringTokenizer st1=new StringTokenizer(bf.readLine());
			String temp=st1.nextToken();
			for(int j=0;j<C;j++) {
				arr[i][j]=temp.charAt(j);
				
			}
		}
		
		for(int i=0;i<R;i++) {
			flag=0;
			DFS(i,0);
		
		}
		System.out.println(answer);
		
		
	}
	public static void DFS(int y,int x) {
		ch[y][x]=1;
		for(int i=0;i<3;i++) {
			int nextY=y+dy[i];
			int nextX=x+dx[i];
			
			if(nextY>=0 && nextY<R && nextX>=0 && nextX<C && arr[nextY][nextX]=='.' && ch[nextY][nextX]==0 && flag==0) {
				ch[nextY][nextX]=1;
				
				if(nextX!=C-1) {
					DFS(nextY,nextX);
				}
				else {
					answer+=1;
					flag=1;
					return ;
				}
			}
		}
	}
	public static void BFS(int y,int x) {
		Queue<Integer> yQ=new ArrayDeque<>();
		Queue<Integer> xQ=new ArrayDeque<>();
		yQ.add(y);
		xQ.add(x);
		int nowY=0;
		int nowX=0;
		while(!yQ.isEmpty() && !xQ.isEmpty()) {
			nowY=yQ.poll();
			nowX=xQ.poll();
			ch[nowY][nowX]=1;
			for(int i=0;i<3;i++) {
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				
				if(nextY>=0 && nextY<R && nextX>=0 && nextX<C && arr[nextY][nextX]=='.' && ch[nextY][nextX]==0) {
					if(nextX==C-1) {
						answer+=1;
					}
					ch[nextY][nextX]=1;
					yQ.add(nextY);
					xQ.add(nextX);
					
				}
			}

		}
	}
}