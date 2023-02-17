import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] arr;
	static ArrayList<position> store;
	static ArrayList<position> home;
	static int[] tmp;
	static int[] ans;
	static int answer=Integer.MAX_VALUE;;
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1=new StringTokenizer(bf.readLine());
		store=new ArrayList<>();
		home=new ArrayList<>();
		
		N=Integer.parseInt(st1.nextToken());
		M=Integer.parseInt(st1.nextToken());
		
		arr=new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st2=new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				int num=Integer.parseInt(st2.nextToken());
				arr[i][j]=num;
				if(num==2) {
					store.add(new position(i,j));
				}
				else if(num==1) {
					home.add(new position(i,j));
				}
			}
		}
		tmp=new int[M];
		com(0,0);
		System.out.println(answer);
		
	}
	static class position{
		int y,x;
		public position(int y,int x) {
			this.y=y;
			this.x=x;
		}
	}
	public static int cal(int y1,int x1,int y2,int x2) {
		return Math.abs(y1-y2)+Math.abs(x1-x2);
	}
	public static void com(int cnt,int start) {
		if(cnt==M) {
			
			int sum=0;
			
			for(int i=0;i<home.size();i++){
				int hY=home.get(i).y;
				int hX=home.get(i).x;
				int dist=Integer.MAX_VALUE;
				for(int t:tmp) {
					int sY=store.get(t).y;
					int sX=store.get(t).x;
					
					dist=Math.min(cal(hY,hX,sY,sX), dist);
				}
				sum+=dist;
			}
			answer=Math.min(sum, answer);


			return ;
		}
		for(int i=start;i<store.size();i++) {
			tmp[cnt]=i;
			com(cnt+1,i+1);
		}
	}
}