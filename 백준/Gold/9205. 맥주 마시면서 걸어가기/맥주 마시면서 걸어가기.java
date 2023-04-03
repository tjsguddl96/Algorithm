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
		public position(int x,int y) {
			this.y=y;
			this.x=x;
		}
	}
	static class element{
		position p;
		int idx;
		public element(position p,int idx) {
			this.p=p;
			this.idx=idx;
		}
	}
	static Queue<element> q;
	static int[] ch;
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int tc=0;tc<t;tc++) {
			int storeN=Integer.parseInt(bf.readLine());
			
			ArrayList<position> arr=new ArrayList<>();
			
			for(int i=0;i<storeN+2;i++) { //0번째는 집 좌표, storeN+1번째는 축제 좌표
				StringTokenizer st=new StringTokenizer(bf.readLine());
				
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				arr.add(new position(x,y));
			}
			ch=new int[arr.size()];
			q=new ArrayDeque<>();
			q.add(new element(arr.get(0),0));
			ch[0]=1;
			
			System.out.println(bfs(arr));
		}
		
		
	}
	public static int calDist(position p1,position p2) {
		return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
	}
	
	public static String bfs(ArrayList<position> arr) {
		while(!q.isEmpty()) {
			element nowE = q.poll();
			position nowP=nowE.p;
			int nowIdx=nowE.idx;
			if(nowIdx==arr.size()-1) {
				return "happy";
			}
			for(int i=0;i<arr.size();i++) {
				int dist=calDist(nowP,arr.get(i));
				
				if(dist<=1000 && ch[i]==0) {
					ch[i]=1;
					q.add(new element(arr.get(i),i));
				}
			}

		}
		return "sad";
	}

}