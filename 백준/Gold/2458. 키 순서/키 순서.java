import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static ArrayList<Integer>[] arrS;
	static ArrayList<Integer>[] arrT;
	static int[] ch;
	static int ans;
	
	static Queue<Integer> q=new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1=new StringTokenizer(bf.readLine());
			n=Integer.parseInt(st1.nextToken());
			m=Integer.parseInt(st1.nextToken());
			arrS=new ArrayList[n+1];
			arrT=new ArrayList[n+1];
			for(int i=0;i<n+1;i++) {
				arrS[i]=new ArrayList<>();
				arrT[i]=new ArrayList<>();
			}
			ans=0;
			for(int i=0;i<m;i++) {
				StringTokenizer st=new StringTokenizer(bf.readLine());
				int n1=Integer.parseInt(st.nextToken());
				int n2=Integer.parseInt(st.nextToken());
				arrS[n1].add(n2);
				arrT[n2].add(n1);
			}
			
			for(int i=1;i<=n;i++) {
				int small=0;
				int tall=0;
				ch=new int[n+1];
				ch[i]=1;
				q.add(i);
				small=bfs1(0); //작은애들 먼저 계산해보자
				ch=new int[n+1];
				ch[i]=1;
				q.add(i);
				tall=bfs2(0);
				if((tall+small)==(n-1)) {
					ans++;
				}
			}
			System.out.println(ans);
		
		
		
	}
	public static int bfs1(int small) {
		while(!q.isEmpty()) {
			int nowIdx=q.poll();
			for(int i=0;i<arrS[nowIdx].size();i++) {
				int nextIdx=arrS[nowIdx].get(i);
				if(ch[nextIdx]==0) {
					ch[nextIdx]=1;
					q.add(nextIdx);
					small++;
				}
			}
		}
		return small;
	}
	public static int bfs2(int tall) {
		while(!q.isEmpty()) {
			int nowIdx=q.poll();
			for(int i=0;i<arrT[nowIdx].size();i++) {
				int nextIdx=arrT[nowIdx].get(i);
				if(ch[nextIdx]==0) {
					ch[nextIdx]=1;
					q.add(nextIdx);
					tall++;
				}
			}
		}
		return tall;
	}
}