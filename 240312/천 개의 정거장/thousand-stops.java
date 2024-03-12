import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class TimeAndCost implements Comparable<TimeAndCost> {
		int time;
		int root;
		int cost;
		int nodeNum;

		public TimeAndCost(int time, int root, int cost, int nodeNum) {
			this.time = time;
			this.root = root;
			this.cost = cost;
			this.nodeNum = nodeNum;
		}

		@Override
		public int compareTo(TimeAndCost o) {
			if (this.cost == o.cost) {
				return this.time-o.time;
			}
			return this.cost - o.cost;
		}
	}

	static class Node {
		int curCost;
		int curRoot;
		int nodeNum;
		Node next;

		public Node(int curRoot, int curCost, int nodeNum, Node next) {
			this.curRoot = curRoot;
			this.curCost = curCost;
			this.nodeNum = nodeNum;
			this.next = next;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());//노선의 개수
		Node[] nodes = new Node[1001];
		for (int i = 1; i <= 1000; i++) {
			nodes[i] = new Node(0, 0, 0, null);
		}
		int[][] minCost = new int[1001][1001];
		for (int i = 1; i <= 1000; i++) {
			Arrays.fill(minCost[i], 2000000000);
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int stationCount = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			for (int j = 0; j < stationCount - 1; j++) {
				int to = Integer.parseInt(st.nextToken());

				nodes[from].next = new Node(i,cost, to, nodes[from].next);

				from = to;
			}
		}//입력 종료

		PriorityQueue<TimeAndCost> q = new PriorityQueue<>();
		//time root cost num 순
		for (Node cur = nodes[A].next; cur != null; cur = cur.next) {
			q.add(new TimeAndCost(1, cur.curRoot, cur.curCost, cur.nodeNum));
		}

		int resultCost = 2_000_000_000;
		int resultTime = 2_000_000_000;

		while (!q.isEmpty()) {
			TimeAndCost cur = q.poll();

			int cNum = cur.nodeNum;

			if (cNum == B) {
				resultTime = cur.time;
				resultCost=cur.cost;
				break;
			}

			for (Node tmp = nodes[cNum].next; tmp != null; tmp = tmp.next) {
				int cmpCost = 0;
				int cmpRoot = 0;

				if (tmp.curRoot == cur.root) {//같은 노선이면 돈을 더 내지 않음
					cmpCost = cur.cost;
					cmpRoot = cur.root;
				} else {
					cmpCost = cur.cost + tmp.curCost;
					cmpRoot = tmp.curRoot;
				}
				//time root cost num 순
				if(minCost[cur.nodeNum][tmp.nodeNum]<cmpCost){
					continue;
				}else if(minCost[cur.nodeNum][tmp.nodeNum]>cmpCost){
					minCost[cur.nodeNum][tmp.nodeNum]=cmpCost;
				}
				q.add(new TimeAndCost(cur.time + 1,cmpRoot, cmpCost, tmp.nodeNum));
			}
		}
		if(resultCost==2_000_000_000&&resultTime==2_000_000_000)
			System.out.println("-1 -1");
		else
			System.out.println(resultCost + " " + resultTime);
	}
}