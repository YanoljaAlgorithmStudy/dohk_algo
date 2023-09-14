import java.util.*;

// https://www.acmicpc.net/problem/24480
public class BJ24480 {
    public List<Integer> dfs(List<ArrayList<Integer>> nodes, int R, boolean[] visited, List<Integer> visitOrder) {
        visited[R] = true;
        visitOrder.add(R);

        for (Integer r :
                nodes.get(R)) {
            if (!visited[r]) {
                visitOrder = dfs(nodes, r, visited, visitOrder);
            }
        }

        return visitOrder;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<ArrayList<Integer>> nodes = new ArrayList<>(); // *
        for (int i = 1; i <= N + 1; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(sc.nextLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes.get(u).add(v);
            nodes.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(nodes.get(i), Collections.reverseOrder());
        }

        boolean[] visited = new boolean[N + 1];
        List<Integer> visitOrder = new ArrayList<>();

        BJ24480 bj24480 = new BJ24480();
        visitOrder = bj24480.dfs(nodes, R, visited, visitOrder);

        int counter = 0;
        for (Integer order :
                visitOrder) {
            counter++;
            System.out.println(order);
        }

        while (true) {
            if (counter >= N) {
                break;
            }
            System.out.print(0);
            counter++;
        }
    }
}
