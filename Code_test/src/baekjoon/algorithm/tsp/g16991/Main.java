package baekjoon.algorithm.tsp.g16991;
  
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point {
	int y, x;

	public Point(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

	@Override
	public String toString() {
		return "Point [y=" + y + ", x=" + x + "]";
	}

}

public class Main {
	static int N;
	static double Graph[][], dp[][];
	static Point[] points;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		points = new Point[N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Point p = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			points[i] = p;
		}

		Graph = new double[N][N];
		dp = new double[N][(1 << N)];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				Graph[i][j] = Graph[j][i] = diff(points[i], points[j]);
			}
		}
		System.out.println(dfs(0, 1));
	}

	static double dfs(int cur, int flag) {
		if (flag == (1 << N) - 1) {
			dp[cur][flag] = Graph[cur][0];
			return Graph[cur][0];
		}

		if (dp[cur][flag] != -1) {
			return dp[cur][flag];
		}
		dp[cur][flag] = Double.POSITIVE_INFINITY;

		for (int i = 0; i < N; i++) {
			if ((flag & (1 << i)) == 0) {
				dp[cur][flag] = Math.min(dfs(i, flag | (1 << i)) + Graph[cur][i], dp[cur][flag]);
			}
		}

		return dp[cur][flag];
	}

	static void draw() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println("==");
	}

	static double diff(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.y - p2.y, 2) + Math.pow(p1.x - p2.x, 2));
	}
}
