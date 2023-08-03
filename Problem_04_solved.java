import java.util.LinkedList;
import java.util.Queue;

public class Problem_04_solved {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int currentWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();

        for (int truck : truck_weights) {
            while (true) {
                if (bridge.isEmpty()) { // 다리가 비어있을 때
                    bridge.offer(truck);
                    currentWeight += truck;
                    answer++;
                    break;
                } else if (bridge.size() == bridge_length) { // 다리가 가득 찼을 때
                    currentWeight -= bridge.poll();
                } else { // 다리에 여유 공간이 있을 때
                    if (currentWeight + truck <= weight) {
                        bridge.offer(truck);
                        currentWeight += truck;
                        answer++;
                        break;
                    } else {
                        bridge.offer(0);
                        answer++;
                    }
                }
            }
        }

        // 모든 트럭이 다리를 건널 때까지 시간 추가
        answer += bridge_length;

        return answer;
    }

    public static void main(String[] args) {
        int bridge_length_1 = 2;
        int bridge_length_2 = 100;
        int bridge_length_3 = 100;

        int weight_1 = 10;
        int weight_2 = 100;
        int weight_3 = 100;

        int[] truck_weights_1 = {7, 4, 5, 6};
        int[] truck_weights_2 = {10};
        int[] truck_weights_3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        int result_1 = solution(bridge_length_1, weight_1, truck_weights_1);
        int result_2 = solution(bridge_length_2, weight_2, truck_weights_2);
        int result_3 = solution(bridge_length_3, weight_3, truck_weights_3);

        System.out.println("result_1 = " + result_1); // 8
        System.out.println("result_2 = " + result_2); // 101
        System.out.println("result_3 = " + result_3); // 110
    }
}
