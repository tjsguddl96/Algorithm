import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n,m;
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());

		st=new StringTokenizer(bf.readLine());
		int[] arr=new int[n+1];
		tree=new long[n+1];
		
		
		int[][] op=new int[m][2];
		
		
		for(int i=1;i<=n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			update(i,arr[i]);
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(bf.readLine());
			op[i][0]=Integer.parseInt(st.nextToken());
			op[i][1]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<m;i++) {
			System.out.println(sum(op[i][1])-sum(op[i][0]-1));
		}
		
		
	}
	private static long sum(int idx) {
		long sum=0;
		while(idx>0) {
			sum+=tree[idx];
			idx -= (idx&-idx);
		}
		return sum;
	}
	private static void update(int idx, int val) {
		while(idx<tree.length) {
			tree[idx]+=val;
			idx+=(idx&-idx);
		}
		
	}

}