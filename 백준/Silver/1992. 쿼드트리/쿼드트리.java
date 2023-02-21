import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int N;
	static String ans="";
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		arr=new int[N][N];
		for(int i=0;i<N;i++) {
			String temp=bf.readLine();
			for(int j=0;j<temp.length();j++) {
				arr[i][j]=temp.charAt(j)-'0';
			}

		}
		qaud(0,0,N);
		System.out.println(ans);

	}
	public static void qaud(int r,int c,int size) { //sum이 size*size이면 1, sum이 0이면 0.
		int sum=0;
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				sum+=arr[i][j];
			}
		}
		if(sum==0) {
			ans+="0";
			//전부 0
		}
		else if(sum==size*size) {
			ans+="1";
			//전부 1
		}
		else {
			int half=size/2;
			ans+="(";
			qaud(r,c,half);
			qaud(r,c+half,half);
			qaud(r+half,c,half);
			qaud(r+half, c+half, half);
			ans+=")";
		}
	}

}