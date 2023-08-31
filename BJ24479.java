import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/24479
public class BJ24479{
    final static int MAX = 100000 + 1;
    static int N, M, R;
    static ArrayList<Integer>[] graphs;

    static boolean[] visitInformationList = new boolean[MAX];
    static int[] answersList = new int[MAX];
    static int orderNumber = 1;

    public void dfs(int R) {
        visitInformationList[R] = true;
        answersList[R] = orderNumber++;

        for (int i = 0; i < graphs[R].size() ; i++) {
            int nextR = graphs[R].get(i);
            if (!visitInformationList[nextR])
                dfs(nextR);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graphs = new ArrayList[MAX];

        for (int i = 1; i <= N; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graphs[u].add(v);
            graphs[v].add(u);
        }

        for (int i = 1; i <= N ; i++) {
            Collections.sort(graphs[i]);
        }

        BJ24479 bj24479 = new BJ24479();
        bj24479.dfs(R);

        for (int i = 1; i <= N ; i++) {
            bw.write(String.valueOf(answersList[i]));
            if (i == N) break;
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}