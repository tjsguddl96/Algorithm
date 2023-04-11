import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		long a,b,c;
		a=Long.parseLong(st.nextToken());
		b=Long.parseLong(st.nextToken());
		c=Long.parseLong(st.nextToken());
		System.out.println(power(a,b,c));
	}
	public static long power(long base, long upper, long c) { //밑, 지수, 나머지 순
		if(upper==1) {
			return base%c;
		}
		long tmp=power(base,(long)(upper/2),c);
		if(upper%2==1) {
			return (((tmp*tmp)%c)*(base%c))%c;
		}
		
		return (tmp*tmp)%c;
	}

}