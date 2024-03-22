import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int num;
		Node next;
		int dist;

		public Node(int num, Node next, int dist) {
			this.num = num;
			this.next = next;
			this.dist = dist;
		}
	}
	static class Search implements Comparable<Search>{
		int num;
		int sum;

		public Search(int num, int sum) {
			this.num = num;
			this.sum = sum;
		}

		@Override
		public int compareTo(Search o) {
			return this.sum-o.sum;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int red1 = Integer.parseInt(st.nextToken());
		int red2 = Integer.parseInt(st.nextToken());
		Node[] nodes=new Node[n+1];
		for(int i=1;i<=n;i++){
			nodes[i]=new Node(i,null,0);
		}
		int[] distances=new int[n+1];
		Arrays.fill(distances,2000000000);

		for(int i=0;i<m;i++){
			st=new StringTokenizer(br.readLine());
			int dot1=Integer.parseInt(st.nextToken());
			int dot2=Integer.parseInt(st.nextToken());
			int dist=Integer.parseInt(st.nextToken());

			nodes[dot1].next=new Node(dot2,nodes[dot1].next,dist);
			nodes[dot2].next=new Node(dot1,nodes[dot2].next,dist);
			
		}//입력 종료

		PriorityQueue<Search> pq=new PriorityQueue<>();
		pq.add(new Search(red1,0));
		distances[red1]=0;
		while(!pq.isEmpty()){
			Search cur=pq.poll();
			if(cur.num==red2){
				System.out.println(cur.sum*2);
				return;
			}

			for(Node curNode=nodes[cur.num];curNode!=null;curNode=curNode.next){
				if(distances[curNode.num]>cur.sum+curNode.dist){
					distances[curNode.num]=cur.sum+curNode.dist;
					pq.add(new Search(curNode.num,distances[curNode.num]));
				}
			}
		}
        System.out.println(-1);
	}
}