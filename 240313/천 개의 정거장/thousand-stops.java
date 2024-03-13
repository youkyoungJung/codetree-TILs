import java.io.*;
import java.util.*;

public class Main {
	static int a, b, n;
	static ArrayList<Node>[] buses;

	static long[] dijk;
	static long[] time;
	static boolean[] fixed;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		buses = new ArrayList[1001];
		for (int i = 0; i < 1001; i++) {
			buses[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			long fare = Integer.parseInt(st.nextToken());
			long size = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			addBus(st, fare, size);
		}

		dijk = new long[1001];
		time = new long[1001];
		fixed = new boolean[1001];

		Arrays.fill(dijk, Long.MAX_VALUE);
		Arrays.fill(time, -1);

		dijk[a] = 0;
		time[a] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
			int comp = Long.compare(a.fare, b.fare);
			if (comp==0) {
				return Long.compare(a.time, b.time);
			} else {
				return comp;
			}
		});
		pq.add(new Node(a, 0, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (fixed[now.to])
				continue;
			fixed[now.to] = true;
			if (now.to == b)
				break;

			ArrayList<Node> bus = buses[now.to];
			for (Node node : bus) {
				int to = node.to;
				long nodeTime = node.time;
				long nodeFare = node.fare;
				if (dijk[to] > now.fare + nodeFare) {
					dijk[to] = now.fare + nodeFare;
					time[to] = time[now.to] + nodeTime;
					pq.add(new Node(to, dijk[to], time[to]));
				} else if (dijk[to] == now.fare + nodeFare) {
					if (time[to] > time[now.to] + nodeTime) {
						time[to] = time[now.to] + nodeTime;
						pq.add(new Node(to, dijk[to], time[to]));
					}
				}
			}
		}
		if (dijk[b] == Long.MAX_VALUE) {
			System.out.println("-1 -1");
		} else {
			System.out.print(dijk[b]);
			System.out.print(" ");
			System.out.print(time[b]);
		}
	}

	private static void addBus(StringTokenizer st, long fare, long size) {
		int[] bus = new int[(int)size];
		for (int i = 0; i < size; i++) {
			bus[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				buses[bus[i]].add(new Node(bus[j], j-i, fare));
			}
		}
	}

	static class Node {
		int to;
		long time;
		long fare;

		public Node(int to, long time, long fare) {
			this.to = to;
			this.time = time;
			this.fare = fare;
		}
	}
}