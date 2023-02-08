
import java.util.Scanner;

public class Main {
	static int n,m;//n은 배열의 크기, m은 연산 횟수
	static int[][] arr;
	static int[][] op;
	static int[][] sum;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		n=sc.nextInt();
		m=sc.nextInt();
		arr=new int[n+2][n+2];
		op=new int[m][4];
		sum=new int[n+2][n+2];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i+1][j+1]=sc.nextInt();
			}
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<4;j++) {
				op[i][j]=sc.nextInt();
			}
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				sum[i][j]=arr[i][j]+sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1];
			}
		}
		for(int i=0;i<m;i++) {
			
			//System.out.println( sum[op[i][3]][op[i][2]]-sum[op[i][1]-1][op[i][0]] -sum[op[i][1]][op[i][0]-1]+sum[op[i][1]-1][op[i][0]-1]     );
			//System.out.println( sum[op[i][2]][op[i][3]]-sum[op[i][3]][op[i][1]-1] -sum[op[i][0]-1][op[i][2]]+sum[op[i][0]-1][op[i][1]-1]   );
			System.out.println( sum[op[i][2]][op[i][3]]  - sum[op[i][0]-1][op[i][3]]  - sum[op[i][2]][op[i][1]-1] +sum[op[i][0]-1][op[i][1]-1]     );
		}
		
		
	}

}
