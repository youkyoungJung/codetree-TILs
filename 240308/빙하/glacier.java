import java.util.*;
import java.io.*;

import org.w3c.dom.Node;

public class Main {

	static int N, M;
	static int[][] graph, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][] visited;
	static ArrayList<Node> water = new ArrayList<>();

	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				graph[i][j] = n;
			}
		}


		//가장자리 구하기
		bfs(0, 0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j])
					water.add(new Node(i, j));
			}
		}

		// print();
		// System.out.println("water = " + water.size());

		int t = -1;
		int cnt = 40001;
		while (!water.isEmpty()) {
			t++;
			water = bfs(water);
			// print();
			// System.out.println("water.size() = " + water.size());
			if(water.isEmpty())
				break;
			cnt = water.size();
		}
		System.out.println(t + " " + cnt);

	}

	private static void bfs(int r, int c) {
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(r, c));
		visited[r][c] = true;
		while (!que.isEmpty()) {
			Node poll = que.poll();
			for (int i = 0; i < 4; i++) {
				int nr = poll.r + dir[i][0];
				int nc = poll.c + dir[i][1];
				if (inGraph(nr, nc) && graph[nr][nc] == 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					que.add(new Node(nr, nc));
				}
			}
		}
	}

	private static ArrayList<Node> bfs(ArrayList<Node> list) {
		Queue<Node> que = new LinkedList<>(list);
		ArrayList<Node> newWater = new ArrayList<>();
		while (!que.isEmpty()) {
			Node poll = que.poll();
			for (int i = 0; i < 4; i++) {
				int nr = poll.r + dir[i][0];
				int nc = poll.c + dir[i][1];
				if (inGraph(nr, nc) && graph[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					graph[nr][nc] = 0;
					newWater.add(new Node(nr, nc));
				}
			}
		}
		return newWater;

	}

	public static boolean inGraph(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(graph[i]));
		}
		System.out.println("+++++++++++++++");
	}
}