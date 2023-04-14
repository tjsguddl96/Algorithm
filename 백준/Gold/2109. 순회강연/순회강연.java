import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class lecture implements Comparable<lecture>{
		int p;
		int d;
		public lecture(int p, int d) {
			this.p=p;
			this.d=d;
		}
		@Override
		public int compareTo(lecture o) {
			int x=o.d-this.d;
			if(x==0) {
				x=o.p-this.p;
			}
			return x;
		}
		
		public String stringTo() {
			return this.p+" "+this.d;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		
		int[] arr=new int[10001];
		PriorityQueue<lecture> lec= new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(bf.readLine());
			int p=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			lec.add(new lecture(p,d));
		}
		while(!lec.isEmpty()) {
			lecture nowLec=lec.poll();
			int nowP=nowLec.p;
			int nowD=nowLec.d;
			if(arr[nowD]==0) {
				arr[nowD]=nowP;
			}else {
				while(arr[nowD]>=nowP && nowD>0) {
					nowD--;
				}
				if(nowD<=0) continue;
				if(arr[nowD]==0) {
					arr[nowD]=nowP;
				}else {
					int tmp=arr[nowD];
					arr[nowD]=nowP;
					while(arr[nowD]!=0 && nowD>0) {
						nowD--;
						int val=arr[nowD];
						arr[nowD]=tmp;
						tmp=val;
					}
				}
			}
		}
		int answer=0;
		for(int i=1;i<10001;i++) {
			if(arr[i]!=0) {
				answer+=arr[i];
			}
		}
		System.out.println(answer);
		
		

	}

}