import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
			StringTokenizer st= new StringTokenizer(bf.readLine());
			long n,r;
			n=Long.parseLong(st.nextToken());
			r=Long.parseLong(st.nextToken());
			long p=1000000007;
			
			
			long facN=fac(n,p);
			long facNR=fac((n-r),p);
			long facR=fac(r,p);
			long bottom=((facNR%p)*(facR%p))%p;
			long per=perma(bottom,p-2,p)%p;
			
			System.out.println((facN%p*per)%p);
		
		
			
	}
	public static long fac(long n,long p) {
		long facto=1;
		
		while(n>0) {
			facto=(facto*n)%p;
			n--;
		}
		
		return facto;
	}
	
	public static long perma(long n,long pow,long p) {
		if(pow==1) {
			return n%p;
		}
		long tmp=perma(n,pow/2,p);
		if(pow%2==1) {
			return (tmp*tmp%p)*n%p;
		}
		return tmp*tmp%p;
	}
	
	

}