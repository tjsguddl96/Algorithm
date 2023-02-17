import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,L;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st1.nextToken());
		L=Integer.parseInt(st1.nextToken());
		
		int[] arr=new int[N];
		StringTokenizer st=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int idx=0;
		while(idx<N && L>=arr[idx]) {


			idx++;
			L++;
		}
		System.out.println(L);
		
	}

}