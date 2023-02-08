import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int[] ans;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		
		ans=new int[M];
		
		com(0,1);
		
		
	}
	
	public static void com(int cnt,int start) {
		if(cnt==M) {
			for(int i=0;i<ans.length;i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return ;
		}
		for(int i=start;i<=N;i++) {
			ans[cnt]=i;
			com(cnt+1,i+1);
		}
	}

}