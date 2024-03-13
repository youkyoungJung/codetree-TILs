import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int id;
	long cost;
	long time;

	public Node(int id, long cost, long time) {
		this.id = id;
		this.cost = cost;
		this.time = time;
	}

	public int compareTo(Node other) {
		if (this.cost == other.cost)
			return Long.compare(this.time, other.time);
		return Long.compare(this.cost, other.cost);
	}
}

public class Main {
	static int a, b, n;
	static ArrayList<long[]>[] buses;
	static long[] dijk;

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
		Arrays.fill(dijk, Long.MAX_VALUE);
		dijk[a] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(a, 0, 0));

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			if (current.id == b) {
				System.out.println(current.cost + " " + current.time);
				return;
			}

			if (current.cost > dijk[current.id]) continue;

			for (long[] next : buses[current.id]) {
				int dest = (int) next[0];
				long fare = next[2];
				long time = next[1];
				long newCost = current.cost + fare;
				long newTime = current.time + time;

				if (newCost < dijk[dest] || (newCost == dijk[dest] && newTime < dijk[dest])) {
					dijk[dest] = newCost;
					pq.add(new Node(dest, newCost, newTime));
				}
			}
		}

		System.out.println("-1 -1");
	}

	private static void addBus(StringTokenizer st, long fare, long size) {
		int[] bus = new int[(int) size];
		for (int i = 0; i < size; i++) {
			bus[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				buses[bus[i]].add(new long[]{bus[j], j - i, fare});
			}
		}
	}
}