import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static ArrayList<Integer> arr[];
	static int[] ch;
	static class cb{
		int n;
		int bacon;
		public cb(int n,int bacon) {
			this.n=n;
			this.bacon=bacon;
		}
	}
	static Deque<cb> q=new ArrayDeque<>();
	static int answer=Integer.MAX_VALUE;
	static int ans;
	static int temp;
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		arr=new ArrayList[n+1];
		for(int i=0;i<n+1;i++) {
			arr[i]=new ArrayList<>();
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(bf.readLine());
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			arr[n1].add(n2);
			arr[n2].add(n1);
		}
		for(int i=1;i<n+1;i++) {
			ch=new int[n+1];
			temp=0;
			cavin(i);
			if(answer>temp) {
				answer=temp;
				ans=i;
			}
		}
		System.out.println(ans);
	}
	public static void cavin(int now) {
		ch[now]=1;
		q.add(new cb(now,0));
		while(!q.isEmpty()) {
			cb nowNode=q.poll();
			int nowIdx=nowNode.n;
			int nowBacon=nowNode.bacon;
			
			for(int i=0;i<arr[nowIdx].size();i++) {
				int nextNode=arr[nowIdx].get(i);
				if(ch[nextNode]==0) {
					temp+=(nowBacon+1);
					ch[nextNode]=nowBacon+1;
					q.add(new cb(nextNode,nowBacon+1));
				}
	
			}
		}
		
	}

}