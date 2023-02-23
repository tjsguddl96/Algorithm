import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,v;
	static int[][] arr;
	static int[] ch;
	static ArrayList<Integer> ans;
	static ArrayList<Integer> ans2;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(bf.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		v=Integer.parseInt(st.nextToken());
		
		
		arr=new int[n][n];
		ch=new int[n];
		ans=new ArrayList<>();
		ans2=new ArrayList<>();
		for(int i=0;i<m;i++) {
			StringTokenizer st1=new StringTokenizer(bf.readLine());
			int n1=Integer.parseInt(st1.nextToken());
			int n2=Integer.parseInt(st1.nextToken());
			
			arr[n1-1][n2-1]=1;
			arr[n2-1][n1-1]=1;
		}
		ans2.add(v);
		ch[v-1]=1;
		dfs(v-1);
		ch=new int[n];
		bfs(v);
		for(int i=0;i<ans2.size();i++) {
			System.out.print(ans2.get(i)+" ");
		}
		System.out.println();
		for(int i=0;i<ans.size();i++) {
			System.out.print(ans.get(i)+" ");
		}
		
		
	}
	public static void dfs(int now) {
		
		//System.out.println(now);
		for(int i=0;i<n;i++) {
			if(ch[i]==0 && arr[now][i]==1) {
				ch[i]=1;
				ans2.add(i+1);
				dfs(i);
			}
		}
		
		
	}
	public static void bfs(int start) {
		Queue<Integer> q=new ArrayDeque<>();
		
		q.offer(start-1);
		ch[start-1]=1;
		ans.add(start);
		while(!q.isEmpty()) {
			int now=q.poll();
			
			for(int i=0;i<n;i++) {
				int next=i;
				if(ch[i]==0 && arr[now][next]==1) {
					q.offer(next);
					ans.add(next+1);
					ch[next]=1;
					
				}
			}
		}
	}

}