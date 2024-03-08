import java.util.*;
import java.io.*;

import org.w3c.dom.Node;

public class Main {

	static int N, M, cnt;
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

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				graph[i][j] = n;
			}
		}
		int t = 0;
		int cnt = 0;
		while (!isMelted()) {
			t++;
			bfs();
			cnt = melt();
		}
		System.out.println(t + " " + cnt);


	}

	public static void bfs() {
		visited = new boolean[N][M];
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(0, 0 ));
		visited[0][0] = true;
		while (!que.isEmpty()) {
			Node poll = que.poll();
			for (int i = 0; i < 4; i++) {
				int nr = poll.r + dir[i][0];
				int nc = poll.c + dir[i][1];
				if (inGraph(nr, nc) && !visited[nr][nc] && graph[nr][nc] == 0) {
					visited[nr][nc] = true;
					que.add(new Node(nr, nc));
				}
			}
		}
	}

	public static int melt() {
		Queue<Node> que = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j]) {
					que.add(new Node(i, j));
				}
			}
		}
		int cnt = 0;
		while (!que.isEmpty()) {
			Node poll = que.poll();
			for (int i = 0; i < 4; i++) {
				int nr = poll.r + dir[i][0];
				int nc = poll.c + dir[i][1];
				if (inGraph(nr, nc) && !visited[nr][nc] && graph[nr][nc] == 1) {
					visited[nr][nc] = true;
					graph[nr][nc] = 0;
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static boolean isMelted() {
		boolean melted = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(graph[i][j] == 1){
					return false;
				}
			}
		}
		return true;
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
	public static void printv() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(visited[i]));
		}
		System.out.println("+++++++++++++++");
	}
}