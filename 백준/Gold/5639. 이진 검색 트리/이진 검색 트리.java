import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static class node{
		int parentIdx;
		int leftIdx;
		int rightIdx;
		public node(int parentIdx,int leftIdx,int rightIdx) {
			this.parentIdx=parentIdx;
			this.leftIdx=leftIdx;
			this.rightIdx=rightIdx;
		}
		@Override
		public String toString() {
			return "node [parentIdx=" + parentIdx + ", leftIdx=" + leftIdx + ", rightIdx=" + rightIdx + "]";
		}
		
	}
	static ArrayList<node> tree;
	static ArrayList<Integer> arr;
	static ArrayList<Integer> asnwer;
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		tree=new ArrayList<>();
		arr=new ArrayList<>();
		String n="";

		while((n=bf.readLine())!=null && !n.isEmpty()) {
			int num=Integer.parseInt(n);
			arr.add(num);
		}
		
		int parentIdx=0;
		int parent=arr.get(parentIdx);
		tree.add(new node(-1,-1,-1)); //parent가 -1인 애는 root임
		for(int i=1;i<arr.size();i++) {
			int nowNode=arr.get(i);
			if(nowNode<parent) {
				tree.get(parentIdx).leftIdx=i;
				tree.add(new node(parentIdx,-1,-1));
				parent=nowNode;
				parentIdx=i;
			}else {
				while(parentIdx!=0 && nowNode>arr.get(tree.get(parentIdx).parentIdx)) { 
					parentIdx=tree.get(parentIdx).parentIdx;
					parent=arr.get(parentIdx);
				}
				while(tree.get(parentIdx).rightIdx!=-1) {
					parentIdx=tree.get(parentIdx).rightIdx;
					parent=arr.get(parentIdx);
				}
				tree.get(parentIdx).rightIdx=i;
				tree.add(new node(parentIdx,-1,-1));
				parentIdx=i;
				parent=nowNode;
			}
//			for(int k=0;k<tree.size();k++) {
//				System.out.print(arr.get(k)+" ");
//				
//				if(tree.get(k).leftIdx==-1) {
//					System.out.print(" no left child ");
//				}else {
//					System.out.print(arr.get(tree.get(k).leftIdx)+" ");
//				}
//				
//				if(tree.get(k).rightIdx==-1) {
//					System.out.print(" no right child ");
//				}
//				else {
//					System.out.print(arr.get(tree.get(k).rightIdx));
//				}
//				
//				System.out.println();
//				
//			}
//			System.out.println("--------------");
		}
		
		asnwer=new ArrayList<>();
		after(0);
		for(int i=0;i<asnwer.size();i++) {
			System.out.println(asnwer.get(i));

		}
//		System.out.println("-----------");
//		
//		for(int i=0;i<tree.size();i++) {
//			System.out.print(arr.get(i)+" ");
//			
//			if(tree.get(i).leftIdx==-1) {
//				System.out.print(" no left child ");
//			}else {
//				System.out.print(arr.get(tree.get(i).leftIdx)+" ");
//			}
//			
//			if(tree.get(i).rightIdx==-1) {
//				System.out.print(" no right child ");
//			}
//			else {
//				System.out.print(arr.get(tree.get(i).rightIdx));
//			}
//			
//			System.out.println();
//			
//		}
//		
	}
	public static void after(int nowIdx) {
		if(nowIdx==-1) {
			return ;
		}
		after(tree.get(nowIdx).leftIdx);
		after(tree.get(nowIdx).rightIdx);
		asnwer.add(arr.get(nowIdx));
		
	}

}

/*
50
30
24
5
27
25
26
28
29
45
98
52
60
106
109
108
110*/