import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		
		for(int tc=0;tc<t;tc++) {
			int x1,y1,r1,x2,y2,r2;
			
			StringTokenizer st=new StringTokenizer(bf.readLine());
			
			x1=Integer.parseInt(st.nextToken());
			y1=Integer.parseInt(st.nextToken());
			r1=Integer.parseInt(st.nextToken());
			x2=Integer.parseInt(st.nextToken());
			y2=Integer.parseInt(st.nextToken());
			r2=Integer.parseInt(st.nextToken());
			double dist=cal(x1,y1,x2,y2);
			
			int r=r1+r2;
			int answer=0;
			if(dist==r) {
				answer=1;
			}else if(dist+r1<r2 || dist+r2<r1) {
				answer=0;
			}else if(dist+r1==r2 || dist+r2==r1) {
				answer=1;
			}else if(dist>r) {
				answer=0;
			}else if(dist<r) {
				answer=2;
			}
			if(dist==0 && r1==r2) {
				answer=-1;
			}
			System.out.println(answer);
		}
	}
	public static double cal(int x1,int y1,int x2,int y2) {
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
}