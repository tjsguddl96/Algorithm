import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int[][] d= {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}}; //dy,dx
	static class fish{
		int num;
		int dir;
		public fish(int num,int dir) {
			this.num=num;
			this.dir=dir;
		}
		
		@Override
		public String toString() {
			return num+", "+dir;
		}
	}
	static class shark{
		int num;
		int dir;
		int y;
		int x;
		public shark(int num,int dir,int y,int x) {
			this.num=num;
			this.dir=dir;
			this.y=y;
			this.x=x;
		}
		
		@Override
		public String toString() {
			return num+", "+dir+", "+y+", "+x;
		}
	}

	static int ans;
	static fish[][] fishMap=new fish[4][4];
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<4;i++) {
			StringTokenizer st=new StringTokenizer(bf.readLine());
			for(int j=0;j<4;j++) {
				int n=Integer.parseInt(st.nextToken());
				int dr=Integer.parseInt(st.nextToken());
				fishMap[i][j]=new fish(n,dr-1);
			}
		}

		shark shark=new shark(fishMap[0][0].num,fishMap[0][0].dir,0,0);
		fishMap[0][0].num=-1; //상어가 있는 칸은 -1임. 빈 칸이랑은 달라!!!
		fishMap=fishMove(fishMap);
		fish[][] origin=copy(fishMap);
		dfs(shark);
		System.out.println(ans);
	}
	public static void dfs(shark nowShark) {
		shark now=nowShark;
		int nowN=now.num;
		int nowD=now.dir;
		int nowY=now.y;
		int nowX=now.x;
		
		fish[][] origin=copy(fishMap);
		ans=Math.max(ans,nowN);
		
		for(int i=1;i<4;i++) {
			int nextY=nowY+d[nowD][0]*i;
			int nextX=nowX+d[nowD][1]*i;
			if(nextY>=0 && nextY<4 && nextX>=0 && nextX<4 && fishMap[nextY][nextX].num!=0) {
				fishMap[nowY][nowX].num=0;
				
				shark next=new shark(nowN+fishMap[nextY][nextX].num,fishMap[nextY][nextX].dir,nextY,nextX);
				fishMap[nextY][nextX].num=-1;
						
				fishMap=fishMove(fishMap);
				
				dfs(next);
				
				fishMap=copy(origin);
			}
		}
	}
	
	public static fish[][] fishMove(fish[][] fishMap) { 
		for(int k=1;k<=16;k++) {
			int flag=0;
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					fish nowFish=fishMap[i][j];
					int nowN=nowFish.num;
					int nowD=nowFish.dir;
					if(nowN==k) {
						int nextY=i+d[nowD][0];
						int nextX=j+d[nowD][1];
						while(!isAvail(nextY,nextX)) {
							nowD=(nowD+1)%8;
							nextY=i+d[nowD][0];
							nextX=j+d[nowD][1];
						}
						fish nextFish=fishMap[nextY][nextX];
						fish tmp=new fish(nextFish.num,nextFish.dir);
						nextFish.num=nowFish.num;
						nextFish.dir=nowD;
						nowFish.num=tmp.num;
						nowFish.dir=tmp.dir;
						flag=1;
						break;
					}
				}
				if(flag==1) {
					break;
				}
			}
		}
		return fishMap;
	}
	
	public static boolean isAvail(int y,int x) {
		if(y>=0 && y<4 && x>=0 && x<4) {
			if(fishMap[y][x].num!=-1) {
				return true;
			}
		}
		return false;
	}
	
	public static fish[][] copy(fish[][] fishMap){
		fish[][] copy=new fish[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				copy[i][j]=new fish(0,0);
				copy[i][j].num=fishMap[i][j].num;
				copy[i][j].dir=fishMap[i][j].dir;
			}
		}
		return copy;
	}
	public static void print(fish[][] fishMap) {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(fishMap[i][j].num+", "+fishMap[i][j].dir+" | ");
			}
			System.out.println();
		}
		System.out.println("--------------");
	}
}