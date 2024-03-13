import java.io.*;
import java.util.*;

public class Main {
	static int a, b, n;
	static ArrayList<int[]>[] buses;

	static int[] dijk;
	static int[] time;
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
			int fare = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			addBus(st, fare, size);
		}

		dijk = new int[1001];
		time = new int[1001];
		fixed = new boolean[1001];

		Arrays.fill(dijk, Integer.MAX_VALUE);
		Arrays.fill(time, -1);

		dijk[a] = 0;
		time[a] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.add(new int[] {a, 0});
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if (fixed[now[0]])
				continue;
			fixed[now[0]] = true;

			ArrayList<int[]> bus = buses[now[0]];
			for (int[] node : bus) {
				if (dijk[node[0]] > now[1] + node[2]) {
					dijk[node[0]] = now[1] + node[2];
					time[node[0]] = time[now[0]] + node[1];
				} else if (dijk[node[0]] == now[1] + node[2]) {
					if (time[node[0]] > time[now[0]] + node[1]) {
						time[node[0]] = time[now[0]] + node[1];
					}
				}
			}
		}
		if (dijk[b] == Integer.MAX_VALUE) {
			System.out.println("-1 -1");
		} else {
			System.out.print(dijk[b]);
			System.out.print(" ");
			System.out.print(time[b]);
		}
	}

	private static void addBus(StringTokenizer st, int fare, int size) {
		int[] bus = new int[size];
		for (int i = 0; i < size; i++) {
			bus[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				buses[bus[i]].add(new int[] {bus[j], j-i, fare});
			}
		}
	}
}