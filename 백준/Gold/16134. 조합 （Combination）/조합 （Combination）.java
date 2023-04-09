import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,r;
	static long p=1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		n=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		
		long fac1=fac(n)%p;
		long fac2=fac(n-r)%p;
		long fac3=fac(r)%p;
		
		long perma1=perma(fac2*fac3%p,p-2);
		long answer=(fac1*perma1%p);
		System.out.println(answer);
		
	}
	public static long fac(int num) {
		long tmp=1;
		while(num>0) {
			tmp=tmp*num%p;
			num--;
		}
		return tmp;
	}
	public static long perma(long base,long pow) {
		if(pow==1) {
			return base%p;
		}
		long tmp=perma(base,(long)(pow/2));
		if(pow%2==0) {
			return tmp*tmp%p;
		}
		return tmp*tmp%p*base%p;
		
	}

}