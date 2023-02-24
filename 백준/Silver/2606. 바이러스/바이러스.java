import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[] ch;
	static int v,e;
	static int ans=-1;
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		v=Integer.parseInt(bf.readLine());
		e=Integer.parseInt(bf.readLine());
		arr=new int[v+1][v+1];
		ch=new int[v+1];
		for(int i=0;i<e;i++) {
			StringTokenizer st= new StringTokenizer(bf.readLine());
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			arr[n1][n2]=arr[n2][n1]=1;
		}
		
		
		bfs(1);
		System.out.println(ans);
		
	}
	
	public static void bfs(int start) {
		Queue<Integer> q=new ArrayDeque<Integer>();
		q.offer(start);
		ch[start]=1;
		while(!q.isEmpty()) {
			int now=q.poll();
			ch[now]=1;
			ans++;
			for(int i=1;i<v+1;i++) {
				int next=i;
				if(ch[next]==0 && arr[now][next]==1) {
					q.offer(next);
					ch[next]=1;
				}
			}
		}
		
	}

}