import java.io.*;
import java.util.StringTokenizer;

public class BJ11724 {
    //https://www.acmicpc.net/problem/11724
    final static int MAX = 1000 + 10;
    static int N, M;
    static boolean graph[][];
    static boolean visited[];
    static int answer = 0;

    static void dfs(int vertex){
        visited[vertex] = true; // b

        for (int j = 1; j <= N; j++) {
            if(visited[j] == false && graph[vertex][j] == true) {
                dfs(j);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];

        int u, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
//            1 2
//            2 5
//            5 1
//            3 4
//            4 6
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph[u][v] = true;
            graph[v][u] = true;
        }

        // dfs
        for (int i = 1; i <= N; i++) {
            if(visited[i] == false) {
                dfs(i);
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}