import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		int oneCnt=onecount(n);
		int ans=0;
		while(oneCnt>k) {
			n+=1;
			oneCnt=onecount(n);
			
			ans++;	
		}
		System.out.println(ans);
		
		
	}
	public static int onecount(int n) {
		int tmp=0;
		String binaryN=Integer.toBinaryString(n);
		for(int i=0;i<binaryN.length();i++) {
			if(binaryN.charAt(i)=='1') {
				tmp++;
			}
		}
		return tmp;
	}

}