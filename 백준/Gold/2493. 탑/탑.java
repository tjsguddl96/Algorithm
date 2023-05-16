import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class tower{
		int idx;
		int val;
		public tower(int idx,int val) {
			this.idx=idx;
			this.val=val;
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		
		int[] ans=new int[n];
		Stack<tower> top=new Stack<>();
		StringTokenizer st=new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			tower now=new tower(i+1,Integer.parseInt(st.nextToken()));
			while(!top.isEmpty() && top.peek().val<now.val) {
				top.pop();
			}
			if(top.isEmpty()) {
				ans[i]=0;
			}else {
				ans[i]=top.peek().idx;
			}
			top.add(now);
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(ans[i]+" ");
		}
		
	}

}