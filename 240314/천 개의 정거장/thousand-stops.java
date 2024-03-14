import java.util.*;
import java.io.*;

public class Main {

	static int A, B, N;
	static boolean[] visited;
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

		public Node(long cost, int time) {
			this.cost = cost;
			this.time = time;
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
				'}';
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		visited = new boolean[1001];
		graph = new ArrayList<>(1001);
		for (int i = 0; i < 1001; i++) {
			graph.add(new ArrayList<>());
		}
		dist = new Node[1001];
		for (int i = 0; i < 1001; i++) {
			dist[i] = new Node(Long.MAX_VALUE, Integer.MAX_VALUE);
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			long cost = Long.parseLong(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			int[] temp = new int[n];
			st = new StringTokenizer(br.readLine());
			int aIdx = n;
			for (int j = 0; j < n; j++) {
				int x = Integer.parseInt(st.nextToken());
				if (x == A) {
					aIdx = j;
				}
				temp[j] = x;
			}
			for (int j = 0; j < n - 1; j++) {
				Edge e = new Edge(temp[j + 1], i, cost, 1);
				graph.get(temp[j]).add(e);
			}
			for (int j = aIdx + 1; j < n; j++) {
				if (dist[temp[j]].cost > cost) {
					dist[temp[j]].cost = cost;
					dist[temp[j]].time = j - aIdx;
				} else if (dist[temp[j]].cost == cost) {
					dist[temp[j]].time = Math.min(dist[temp[j]].time, j - aIdx);
				}
			}
			// for (int k = 0; k < 6; k++) {
			// 	System.out.println(dist[k]);
			// }
			// System.out.println("=======");
		}
		// for (int i = 1; i < 1001; i++) {
		// 	System.out.println(dist[i]);
		// }

		dijkstra(A);

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

		// pq.add(new Edge(start, -1, 0, 0));

		dist[start] = new Node(0, 0);

		while (!pq.isEmpty()) {
			Edge poll = pq.poll();
			// System.out.println("poll = " + poll);
			for (int i = 0; i < graph.get(poll.to).size(); i++) {
				Edge cur = graph.get(poll.to).get(i);
				if (cur.line == poll.line) {
					if (dist[cur.to].cost > poll.cost) {
						dist[cur.to].cost = poll.cost;
						dist[cur.to].time = poll.time + 1;
					} else if (dist[cur.to].cost == poll.cost) {
						if (dist[cur.to].time >= poll.time + 1) {
							dist[cur.to].time = poll.time + 1;
						}
					}
					pq.add(new Edge(cur.to, cur.line, poll.cost, poll.time + 1));
				} else {
					if (dist[cur.to].cost > poll.cost + cur.cost) {
						dist[cur.to].cost = poll.cost + cur.cost;
						dist[cur.to].time = poll.time + 1;
						pq.add(new Edge(cur.to, cur.line, poll.cost + cur.cost, poll.time + 1));
					} else if (dist[cur.to].cost == poll.cost + cur.cost) {
						if (dist[cur.to].time >= poll.time + 1) {
							dist[cur.to].time = poll.time + 1;
						pq.add(new Edge(cur.to, cur.line, poll.cost + cur.cost, poll.time + 1));
						}
					}
				}
			}
		}
	}

}