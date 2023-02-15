import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.math.*;
public class Main {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		PriorityQueue<node> pq=new PriorityQueue<>();
		
		N=sc.nextInt();
		for(int i=0;i<N;i++) {
			int n=sc.nextInt();
			if(n!=0) {
				pq.offer(new node(n,Math.abs(n)));
			}
			else {
				if(!pq.isEmpty()) {
					System.out.println(pq.poll().idx);
				}
				else {
					System.out.println(0);
				}
			}
		}
		
		
	}
	
	
	static class node implements Comparable<node>{
		int idx;
		int ab;
		public node(int idx, int ab) {
			this.idx = idx;
			this.ab = ab;
		}
		@Override
		public int compareTo(node o) {
			int x=this.ab-o.ab;
			if(x==0) {
				x=this.idx-o.idx;
			}
			return x;
			
		}
		
	}

}