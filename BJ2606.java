import java.io.*;
import java.util.StringTokenizer;

public class BJ2606{
    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;
    static int answer;

    public static void dfs(int idx) {
        visited[idx] = true;
        answer++;

        for (int i = 1; i < N; i++) {
            if(visited[i] == false && graph[idx][i] == true)
                dfs(i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        // 1. 자료구조에 값 채우기
        for (int i = 0; i < M; i++) {
            int x, y;
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x][y] = true; // 나머지 위치의 요소들은 자동으로 false인가?
            graph[y][x] = true;
        }

        // 2. DFS 호출
        dfs(1);

        // 3. 출력
        bw.write(String.valueOf(answer - 1));

        br.close();
        bw.close();
    }
}