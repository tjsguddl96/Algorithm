
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int r,c;
	static char[][] arr;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static Set<Character> set;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		set=new HashSet<>();
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		arr=new char[r][c];

		for(int i=0;i<r;i++) {
			String str=bf.readLine();
			for(int j=0;j<c;j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		dfs(0,0,1,arr[0][0]+"");
		
		System.out.println(ans);
	}
	static class position{
		int x;
		int y;
		int cnt;
		String charc;
		public position(int y,int x,int cnt,String charc) {
			this.y=y;
			this.x=x;
			this.cnt=cnt;
			this.charc=charc;
		}
		@Override
		public String toString() {
			return "position [x=" + x + ", y=" + y + ", cnt=" + cnt + ", charc=" + charc + "]";
		}
		
	}
	public static void dfs(int nowY,int nowX,int nowCnt, String nowChar) {

		//System.out.println(nowCnt+" "+nowChar);
		

		for(int i=0;i<4;i++) {
			int nextY=nowY+dy[i];
			int nextX=nowX+dx[i];

			if(nextY>=0 && nextY<r && nextX>=0 && nextX<c  && check(arr[nextY][nextX],nowChar)) {
				
			

				dfs(nextY,nextX,nowCnt+1,nowChar+arr[nextY][nextX]);
			
			}
		}

		ans=Math.max(ans, nowCnt);
		
	}
	public static boolean check(char c,String str) {
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==c) {
				return false;
			}
		}

		return true;
	}
}
