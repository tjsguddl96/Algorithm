import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		long n,k;
		n=Long.parseLong(bf.readLine());
		k=Long.parseLong(bf.readLine());
		
		long left=1;
		long right=n*n;
		long mid=0;
		while(left<=right) {
			
			mid=(long)((left+right)/2);
			long tmp=0;
			for(long i=1;i<=n;i++) {
				tmp+=Math.min((long)(mid/i),n);
				if(tmp>k) {
					break;
				}
			}
			if(tmp>=k) {
				right=mid-1;
			}
			else {
				left=mid+1;
				mid=left;
			}

		}
		System.out.println(mid);

	}

}