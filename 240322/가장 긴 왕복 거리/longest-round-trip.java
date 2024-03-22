import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int num;
		int dist;
		Node next;

		public Node(int num, int dist, Node next) {
			this.num = num;
			this.dist = dist;
			this.next = next;
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
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int x=Integer.parseInt(st.nextToken());

		Node[] nodes=new Node[n+1];
		for(int i=1;i<=n;i++){
			nodes[i]=new Node(i,0,null);
		}


		for(int i=0;i<m;i++){
			st=new StringTokenizer(br.readLine());
			int source=Integer.parseInt(st.nextToken());
			int destination=Integer.parseInt(st.nextToken());
			int dist=Integer.parseInt(st.nextToken());

			nodes[source].next=new Node(destination,dist,nodes[source].next);
			
		}//입력종료

		int maxTime=0;
		for(int i=1;i<=n;i++){
			int[] distances=new int[n+1];
			Arrays.fill(distances,200000000);
			distances[i]=0;
			if(i==x){
				continue;
			}
			PriorityQueue<Search> pq=new PriorityQueue<>();
			pq.add(new Search(i,0));

			int toX=0;
			int fromX=0;
			while(!pq.isEmpty()){
				Search cur=pq.poll();
				if(cur.num==x){
					toX=cur.sum;
					break;
				}

				for(Node curNode=nodes[cur.num].next;curNode!=null;curNode=curNode.next){
					if(distances[curNode.num]>cur.sum+curNode.dist){
						distances[curNode.num]=cur.sum+curNode.dist;
						pq.add(new Search(curNode.num,distances[curNode.num]));
					}
				}

			}//편도1 끝

			Arrays.fill(distances,200000000);
			distances[x]=0;
			pq=new PriorityQueue<>();
			pq.add(new Search(x,0));

			while(!pq.isEmpty()){
				Search cur=pq.poll();
				if(cur.num==i){
					fromX=cur.sum;
					break;
				}

				for(Node curNode=nodes[cur.num].next;curNode!=null;curNode=curNode.next){
					if(distances[curNode.num]>cur.sum+curNode.dist){
						distances[curNode.num]=cur.sum+curNode.dist;
						pq.add(new Search(curNode.num,distances[curNode.num]));
					}
				}

			}//편도2 끝


			maxTime=Math.max(toX+fromX,maxTime);
		}

		System.out.println(maxTime);
	}
}