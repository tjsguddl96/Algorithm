
import java.util.Arrays;
import java.util.Scanner;

public class Main{
	static int n,m;
	static int[] arr;
	static int[][] range;
	static int[] sum;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		arr=new int[n];
		sum=new int[n+1];
		range=new int[m][2];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=1;i<n+1;i++) {
			sum[i]=sum[i-1]+arr[i-1];
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<2;j++) {
				range[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<m;i++) {
			System.out.println(sum[range[i][1]]-sum[range[i][0]-1]);
		}
	}

}
