import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int nodeNum;
		int cost;
		Node next;

		public Node(int num, int cost, Node next) {
			this.nodeNum = num;
			this.cost = cost;
			this.next = next;
		}
	}
	static class DistInfo implements Comparable<DistInfo>{
		int nodeNum;
		int cost;

		public DistInfo(int nodeNum, int cost) {
			this.nodeNum = nodeNum;
			this.cost = cost;
		}

		@Override
		public int compareTo(DistInfo o) {
			return this.cost-o.cost;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());

		st=new StringTokenizer(br.readLine());
		int[] abc=new int[3];
		for(int i=0;i<3;i++){
			abc[i]=Integer.parseInt(st.nextToken());
		}

		int[][] minDist=new int[3][N+1];
		for(int i=0;i<3;i++){
			Arrays.fill(minDist[i],2_000_000_000);
		}

		Node[] nodes=new Node[N+1];
		for(int i=1;i<=N;i++){
			nodes[i]=new Node(i,0,null);
		}

		for(int i=0;i<M;i++){
			st=new StringTokenizer(br.readLine());
			int first=Integer.parseInt(st.nextToken());
			int second=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());

			nodes[first].next=new Node(second,cost,nodes[first].next);
			nodes[second].next=new Node(first,cost,nodes[second].next);
		}//입력 종료

		for(int i=0;i<3;i++){
			PriorityQueue<DistInfo> pq=new PriorityQueue<>();
			pq.add(new DistInfo(abc[i],0));
			minDist[i][abc[i]]=0;
			while(!pq.isEmpty()){
				DistInfo cur=pq.poll();

				for(Node tmp=nodes[cur.nodeNum].next;tmp!=null;tmp=tmp.next){
					if(minDist[i][tmp.nodeNum]>cur.cost+ tmp.cost){
						minDist[i][tmp.nodeNum]=cur.cost+ tmp.cost;
						pq.add(new DistInfo(tmp.nodeNum,minDist[i][tmp.nodeNum]));
					}
				}
			}
		}

		int maxmin=0;
		for(int i=1;i<=N;i++){
			int min=100000000;
			for(int j=0;j<3;j++){
				min=Math.min(minDist[j][i],min);
			}
			maxmin=Math.max(maxmin,min);
		}

		System.out.println(maxmin);

	}
}