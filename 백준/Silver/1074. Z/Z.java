import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,R,C;
	static int count,answer;
	static double N;

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		n=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken()); //행 
		C=Integer.parseInt(st.nextToken()); //열
		
		N=Math.pow(2, n);
		
		
		travel(0,0,N);
		
		
	}
	public static void travel(double r,double c,double size) {
		if(r==R && c==C) {
			answer=count;
			System.out.println(answer);
			System.exit(0);
		}
		
		if(r<=R && R<r+size && c<=C && C<c+size){ //r=5, c=4
			double half=size/2;
			travel(r,c,half); //0 0
			travel(r,c+half,half); // 0 4
			travel(r+half,c,half); //4 0
			travel(r+half,c+half,half); //4 4 
			
		}
		else {
			count+=size*size;
		}
		
		
	}

}