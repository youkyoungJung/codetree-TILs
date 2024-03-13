import java.io.*;
import java.util.*;

public class Main {
	static int a, b, n;
	static ArrayList<long[]>[] buses;

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
		PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
			int comp = Long.compare(a[1], b[1]);
			if (comp==0) {
				return Long.compare(a[2], b[2]);
			} else {
				return comp;
			}
		});
		pq.add(new long[] {a, 0, 0});
		while (!pq.isEmpty()) {
			long[] now = pq.poll();
			if (fixed[(int)now[0]])
				continue;
			fixed[(int)now[0]] = true;
			if (now[0] == b)
				break;

			ArrayList<long[]> bus = buses[(int)now[0]];
			for (long[] node : bus) {
				if (dijk[(int)node[0]] > now[1] + node[2]) {
					dijk[(int)node[0]] = now[1] + node[2];
					time[(int)node[0]] = time[(int)now[0]] + node[1];
					pq.add(new long[] {node[0], dijk[(int)node[0]], time[(int)node[0]]});
				} else if (dijk[(int)node[0]] == now[1] + node[2]) {
					if (time[(int)node[0]] > time[(int)now[0]] + node[1]) {
						time[(int)node[0]] = time[(int)now[0]] + node[1];
						pq.add(new long[] {node[0], dijk[(int)node[0]], time[(int)node[0]]});
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
				buses[bus[i]].add(new long[] {bus[j], j-i, fare});
			}
		}
	}
}