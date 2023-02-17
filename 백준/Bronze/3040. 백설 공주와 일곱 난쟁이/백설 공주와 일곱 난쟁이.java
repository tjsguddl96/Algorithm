import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] arr;
	static int[] tmp;
	public static void main(String[] args) throws IOException {

		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		arr=new int[9];
		tmp=new int[7];
		for(int i=0;i<9;i++) {
			arr[i]=Integer.parseInt(bf.readLine());
		}
		com(0,0);
	}
	public static void com(int cnt,int start) {
		if(cnt==7) {
			int sum=0;
			for(int i=0;i<7;i++) {
				sum+=tmp[i];
			}
			if(sum==100) {
				for(int i=0;i<7;i++) {
					System.out.println(tmp[i]);
				}
			}
			return ;
		}
		for(int i=start;i<9;i++) {
			tmp[cnt]=arr[i];
			com(cnt+1,i+1);
		}
	}

}