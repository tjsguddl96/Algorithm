import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n,m,k;
	static long[] tree; 
	static long[] arr; 
	static ArrayList<Long> answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken()); //변경 횟수
		k=Integer.parseInt(st.nextToken()); //합 횟수
		
		tree=new long[n+1];
		arr=new long[n+1];
		answer=new ArrayList<>();
		
		for(int i=1;i<=n;i++) {
			long val=Long.parseLong(bf.readLine());
			arr[i]=val;
			update(i,val);
		}
		
		for(int i=0;i<(m+k);i++) {
			st=new StringTokenizer(bf.readLine());
			int op=Integer.parseInt(st.nextToken()); //1이면 n1을 n2로 변경, 2이면 n1부터 n2까지의 합 출력
			long num1=Long.parseLong(st.nextToken());
			long num2=Long.parseLong(st.nextToken());
			
			if(op==1) { //n1번째 수를 n2로 값 변경
				long gap=num2-arr[(int)num1];
				arr[(int)num1]=num2;
				update((int)num1,gap);
			}
			else { //num1부터 num2까지의 합
				
				answer.add(sum((int)num2)-sum((int)num1-1));
			}
		}
		
		for(int i=0;i<answer.size();i++) {
			System.out.println(answer.get(i));
		}
		

	}
	public static long sum(int idx) {
		long sum=0;
		while(idx>0) {
			sum+=tree[idx];
			idx-=(idx&-idx);
		}
		return sum;
	}
	public static void update(int idx,long val) {
		while(idx<tree.length) {
			tree[idx]+=val;
			idx+=(idx&-idx);
		}
	}
	

}