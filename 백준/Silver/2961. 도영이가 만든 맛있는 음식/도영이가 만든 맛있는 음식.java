import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] sour;
	static int[] bitter;
	static boolean[] ch;
	static int[] sourL,bitterL;
	static int N;
	static int min,s,b;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		sour=new int[N];
		bitter=new int[N];
		ch=new boolean[N];
		min=99999999;
		for (int i=0;i<N;i++) {
			sour[i]=sc.nextInt();
			bitter[i]=sc.nextInt();
		}
		for(int i=1;i<=N;i++) {
			com(0,i);
		}
		
		System.out.println(min);
		
	}
	public static void com(int cnt,int R) {
		if(cnt==R) {
			int s=1;
			int b=0;
			for(int i=0;i<N;i++) {
				if (ch[i]==true) {
					s*=sour[i];
					b+=bitter[i];
					if(min>Math.abs(s-b)) {
						min=Math.abs(s-b);
					}
				}
				
			}
			return ;
		}
		
		ch[cnt]=true;
		com(cnt+1,R);
		
		ch[cnt]=false;
		com(cnt+1,R);
		
	}
	

}