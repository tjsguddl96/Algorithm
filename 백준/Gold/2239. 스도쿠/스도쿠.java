import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int[][] board;
	static ArrayList<position> emptyList;
	static int flag=0;
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
		board=new int[9][9];
		
		emptyList=new ArrayList<>();
		
		for(int i=0;i<9;i++) {
			String str=bf.readLine();
			for(int j=0;j<str.length();j++) {
				int a=str.charAt(j)-'0';
				board[i][j]=a;
				if(board[i][j]==0) {
					emptyList.add(new position(i,j));
				}
			}
		}
		write(0);
		
	}
	
	public static void write(int cnt) {
		
		
		if(cnt==emptyList.size()) {
			if(flag==0) {
				for(int i=0;i<9;i++) {
					for(int j=0;j<9;j++) {
						System.out.print(board[i][j]);
					}
					System.out.println();
				}
				flag=1;
			}
			return ;
		}
		
		position nowP=emptyList.get(cnt);
		int nowY=nowP.y;
		int nowX=nowP.x;
		
		int[] ch=new int[10];
		
		//가로 체크
		for(int i=0;i<9;i++) {
			if(board[nowY][i]!=0) {
				ch[board[nowY][i]]=1;
			}
		}
		
		//세로 체크
		for(int i=0;i<9;i++) {
			if(board[i][nowX]!=0) {
				ch[board[i][nowX]]=1;
			}
		}
		
		//3X3 체크
		int startY=(int)(nowY/3)*3;
		int startX=(int)(nowX/3)*3;
		for(int i=startY;i<startY+3;i++) {
			for(int j=startX;j<startX+3;j++) {
				if(board[i][j]!=0) {
					ch[board[i][j]]=1;
				}
			}
		}
		
		for(int i=1;i<10;i++) {
			if(ch[i]==0) {
				board[nowY][nowX]=i;
				write(cnt+1);
				if(flag==1) {
					break;
				}
				board[nowY][nowX]=0;
			}
		}
		
		
		
		
		
		
	}
	
	
	
}