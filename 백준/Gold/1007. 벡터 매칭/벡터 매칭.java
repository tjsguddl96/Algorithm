import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] res;
	static int[] res2;
	static int n;
	static double ans;
	static ArrayList<position> arr;
	static class position{
		int x;
		int y;
		public position(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		
		for(int tc=0;tc<t;tc++) {
		
			n=Integer.parseInt(bf.readLine());
			arr=new ArrayList<>();
			res=new int[n/2];
			res2=new int[n/2];
			ans=999999999;
			for(int i=0;i<n;i++) {
				StringTokenizer st=new StringTokenizer(bf.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				arr.add(new position(x,y));
			}
			
			com(0,0);
			System.out.println(ans);
		}
		
	}
	public static void com(int cnt,int start) {
		if(cnt==(n/2)) {
			int tmp=0;
			for(int i=0;i<n;i++) {
				int flag=0;
				for(int j=0;j<res.length;j++) {
					if(res[j]==i) {
						flag=1;
						break;
					}
				}
				if(flag==0) {
					res2[tmp]=i;
					tmp++;
				}
			}
			long sumX1=0;
			long sumY1=0;
			long sumX2=0;
			long sumY2=0;
			for(int i=0;i<res.length;i++) {
				sumX1+=arr.get(res[i]).x;
				sumY1+=arr.get(res[i]).y;
			}
			for(int i=0;i<res2.length;i++) {
				sumX2+=arr.get(res2[i]).x;
				sumY2+=arr.get(res2[i]).y;
			}

			double root1=Math.sqrt((long)((sumX1-sumX2)*(sumX1-sumX2)) + ((sumY1-sumY2)*(sumY1-sumY2)));
			double root2=Math.sqrt((long)((sumX2-sumX1)*(sumX2-sumX1)) + ((sumY2-sumY1)*(sumY2-sumY1)));
			
			double minRoot=Math.min(root1, root2);
			ans=Math.min(ans, minRoot);

			
			return ; 
		}
		for(int i=start;i<n;i++) {
			res[cnt]=i;
			com(cnt+1,i+1);
		}
	}
}
/*
6
5 5
5 -5
-5 5
-5 -5
5 -5
-5 5
*/