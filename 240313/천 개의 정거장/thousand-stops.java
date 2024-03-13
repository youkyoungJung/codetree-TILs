import java.util.*;
import java.io.*;

public class Main {

	static int A, B, N;
	static int[] fairs;
	static Node[] dist;

	static ArrayList<ArrayList<Edge>> graph;

	static class Edge implements Comparable<Edge> {
		int to, line, time;
		long cost;

		public Edge(int to, int line, long cost, int time) {
			this.to = to;
			this.line = line;
			this.cost = cost;
			this.time = time;
		}

		@Override
		public int compareTo(Edge e) {
			if (this.cost == e.cost) {
				return Long.compare(this.time, e.time);
			}
			return Long.compare(this.cost, e.cost);
		}

		@Override
		public String toString() {
			return "Edge{" +
				"to=" + to +
				", line=" + line +
				", time=" + time +
				", cost=" + cost +
				'}';
		}
	}

	static class Node implements Comparable<Node> {
		int time;
		long cost;
		int line;
		public Node(long cost, int time, int line) {
			this.cost = cost;
			this.time = time;
			this.line = line;
		}

		@Override
		public int compareTo(Node n) {
			if (this.cost == n.cost) {
				return Long.compare(this.time, n.time);
			}
			return Long.compare(this.cost, n.cost);
		}

		@Override
		public String toString() {
			return "Node{" +
				"time=" + time +
				", cost=" + cost +
				", line=" + line +
				'}';
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		fairs = new int[N + 1];
		graph = new ArrayList<>(1001);
		for (int i = 0; i < 1001; i++) {
			graph.add(new ArrayList<>());
		}
		dist = new Node[1001];
		for (int i = 0; i < 1001; i++) {
			dist[i] = new Node(Long.MAX_VALUE, Integer.MAX_VALUE, 0);
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			int cost = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			fairs[i] = cost;
			int[] temp = new int[n];
			st = new StringTokenizer(br.readLine());

			boolean inA = false;
			int idx= -1;
			for (int j = 0; j < n; j++) {
				int x = Integer.parseInt(st.nextToken());
				if (x == A) {
					inA =true;
					idx = j;
				}
				temp[j] = x;
			}
			for (int j = 0; j < n - 1; j++) {
				if (inA && j > idx) {
					if(dist[temp[j]].cost > cost){
						int t = j -idx;
						if(t < dist[temp[j]].time) {
							dist[temp[j]].cost = cost;
							dist[temp[j]].time = j - idx;
							dist[temp[j]].line = i;
						}

					}
				}
				graph.get(temp[j]).add(new Edge(temp[j+1], i, cost, 0));
			}
			if (inA) {
				if(dist[temp[n-1]].cost > cost){
					int t = n-1 -idx;
					if(t> 0 && t < dist[temp[n-1]].time) {
						dist[temp[n-1]].cost = cost;
						dist[temp[n-1]].time = t;
						dist[temp[n-1]].line = i;
					}
				}
			}
			// for (int k = 1; k <= 6; k++) {
			// 	System.out.println(dist[k]);
			// }
			// System.out.println("======1=====");
			// int from = Integer.parseInt(st.nextToken());
			// int to = 0;
			// int origin = from;
			// for (int j = 0; j < n - 1; j++) {
			// 	to = Integer.parseInt(st.nextToken());
			//
			// 	graph.get(from).add(new Edge(to, i, cost, 0));
			// 	from = to;
			// }
			// graph.get(from).add(new Edge(origin, i, cost, 0));
		}
		// for (Edge edge : graph.get(1)) {
		// 	System.out.println(edge);
		// }
		// for(int i = 1; i < 9; i++) {
		// 	System.out.println(i + " : " + graph.get(i).size());
		// }
		// System.out.println("====dijkstra====");

		dijkstra(A);
		// for (int i = 0; i < 6; i++) {
		// 	System.out.println(dist[i]);
		// }
		if (dist[B].cost == Long.MAX_VALUE) {
			System.out.println("-1 -1");
		} else {
			System.out.println(dist[B].cost + " " + dist[B].time);
		}
	}

	public static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (Edge edge : graph.get(start)) {
			pq.add(edge);
		}
		// pq.add(new Edge(start, 0, 0, 0));

		dist[start] = new Node(0, 0, -1);

		while (!pq.isEmpty()) {
			Edge poll = pq.poll();
			for (int i = 0; i < graph.get(poll.to).size(); i++) {
				Edge cur = graph.get(poll.to).get(i);
				//같을때
				if (dist[poll.to].line == cur.line) {
					if (dist[cur.to].cost >= dist[poll.to].cost) {
						dist[cur.to].time = dist[poll.to].time + 1;
						dist[cur.to].cost = dist[poll.to].cost;
						dist[cur.to].line = dist[poll.to].line;
						pq.add(new Edge(cur.to, cur.line, dist[cur.to].cost, dist[cur.to].time));
					}
				} else {
					//다를때
					if (dist[cur.to].cost > poll.cost + cur.cost+1) {
						dist[cur.to].cost = dist[poll.to].cost + cur.cost;
						dist[cur.to].time = poll.time + 1;
						dist[cur.to].line = cur.line;
						pq.add(new Edge(cur.to, cur.line, dist[cur.to].cost, dist[cur.to].time));
					} else if (dist[cur.to].cost == poll.cost + cur.cost){
						if(dist[cur.to].time > dist[poll.to].time + 1) {
							dist[cur.to].time = poll.time + 1;
							dist[cur.to].line = cur.line;
							pq.add(new Edge(cur.to, cur.line, dist[cur.to].cost, dist[cur.to].time));
						}
					}
				}

			}
		}
	}

}