import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] preorder;
	static int[] inorder;
	static int[] inorderIdx;
	static int[] ch;
	static int root;
	static int[][] tree;
	static ArrayList<Integer> ans[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		ans=new ArrayList[t];
		for(int tc=0;tc<t;tc++) {
			n=Integer.parseInt(bf.readLine());
			preorder=new int[n];
			inorder=new int[n];
			inorderIdx=new int[n+1];
			ch=new int[n+1];
			tree=new int[n+1][2];
			ans[tc]=new ArrayList<>();
			
			StringTokenizer st=new StringTokenizer(bf.readLine());
			for(int i=0;i<n;i++) {
				preorder[i]=Integer.parseInt(st.nextToken());
			}
			st=new StringTokenizer(bf.readLine());
			for(int i=0;i<n;i++) {
				int N=Integer.parseInt(st.nextToken());
				inorderIdx[N]=i;
				inorder[i]=N;
			}
			root=preorder[0];
			ch[root]=1;
			for(int i=1;i<n;i++) {
				int now=preorder[i];
				int parent=0;
				int flag=0;
				for(int j=inorderIdx[now]+1;j<n;j++) {
					if(flag==1) break;
					if(ch[inorder[j]]==1) {
						flag=1;
						parent=inorder[j];
					}
				}
				if(flag==0) {
					parent=getParent(root);
					tree[parent][1]=now; //오른쪽으로
				}
				else {
					if(tree[parent][0]==0) {
						tree[parent][0]=now;
					}else {
						parent=getParent(tree[parent][0]);
						tree[parent][1]=now;
					}
				}
				ch[now]=1;
				
			}
			postOrder(root,tc);
			
//			for(int i=1;i<n+1;i++) {
//				System.out.print(i+"의 자식");
//				for(int j=0;j<2;j++) {
//					System.out.print(tree[i][j]+" ");
//				}
//				System.out.println();
//			}
		}
		for(int i=0;i<t;i++) {
			for(int j=0;j<ans[i].size();j++) {
				System.out.print(ans[i].get(j)+" ");
			}
			System.out.println();
		}
	}
	public static void postOrder(int parent,int tc) {
		if(tree[parent][0]!=0) {
			postOrder(tree[parent][0],tc);
		}
		if(tree[parent][1]!=0) {
			postOrder(tree[parent][1],tc);
		}
		ans[tc].add(parent);
		
	}
	public static int getParent(int now) {
		while(tree[now][1]!=0) {
			now=tree[now][1];
		}
		return now;
	}

}