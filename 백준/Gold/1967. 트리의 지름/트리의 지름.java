import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static class node{
		int idx;
		int w;
		public node(int idx,int w) {
			this.idx=idx;
			this.w=w;
		}
	}
	static int n;
	static ArrayList<node> tree[];
	static int[] ch;
	static int maxIdx;
	static int maxVal;
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(bf.readLine());
		tree=new ArrayList[n+1];
		ch=new int[n+1];
		
		for(int i=0;i<n+1;i++) {
			tree[i]=new ArrayList<>();
		}
		for(int i=0;i<n-1;i++) {
			StringTokenizer st=new StringTokenizer(bf.readLine());
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			tree[n1].add(new node(n2,w));
			tree[n2].add(new node(n1,w));
		}
		ch[1]=1;
		cal(1,0);
		ch=new int[n+1];
		ch[maxIdx]=1;
		maxVal=0;
		cal(maxIdx,0);
		System.out.println(maxVal);
		
	}
	public static void cal(int now,int weight) {
		if(weight>maxVal) {
			maxVal=weight;
			maxIdx=now;
		}
		
		for(int i=0;i<tree[now].size();i++) {
			node next=tree[now].get(i);
			if(ch[next.idx]==0) {
				ch[next.idx]=1;
				cal(next.idx,weight+next.w);
			}
		}
		
	}

}