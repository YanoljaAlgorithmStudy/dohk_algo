import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Problem_04_unsolved {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int initialLength = truck_weights.length;
        ArrayList<Integer> truckQueue = new ArrayList<>();
        ArrayList<Integer> completedTruck = new ArrayList<>();
        ArrayList<Integer> crossingTruck = new ArrayList<>();
        HashMap<Integer, Integer> innerCounter = new HashMap<>(); // For counting per truck

        for(int truck : truck_weights){
            truckQueue.add(truck);
        }

        while(true) {
            // exit condition
            if (completedTruck.size() == initialLength) {
                break;
            }

            // crossing truck -> completed truck
            if(!crossingTruck.isEmpty()) {
                for (Map.Entry<Integer, Integer> count : innerCounter.entrySet()) { // *
                    Integer truckWeight = count.getKey();
                    Integer proceeding = count.getValue();
                    if (proceeding == bridge_length) {
                        completedTruck.add(truckWeight);
                        innerCounter.remove(truckWeight);
                        crossingTruck.remove(truckWeight);
                    }
                }
            }


            // truckQueue queue -> crossing truck
            if(!truckQueue.isEmpty()){
                if(crossingTruck.size() < bridge_length){
                    int sum = innerCounter.keySet().stream().mapToInt(Integer::intValue).sum() + truckQueue.get(0);

                    if(weight - sum>=0){
                        innerCounter.put(truckQueue.get(0), 1);
                        crossingTruck.add(truckQueue.remove(0));
                    } else {
                        for (Map.Entry<Integer, Integer> count : innerCounter.entrySet()) {
                            Integer truckWeight = count.getKey();
                            Integer proceeding = count.getValue();
                            innerCounter.put(truckWeight, proceeding+1);
                        }
                    }
                } else {
                    continue;
                }
            } else {
                break;
            }
            answer += 1;
        }

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
//        int result_2 = solution(bridge_length_2, weight_2, truck_weights_2);
//        int result_3 = solution(bridge_length_3, weight_3, truck_weights_3);

        System.out.println("result_1 = " + result_1); // 8
//        System.out.println("result_2 = " + result_2); // 101
//        System.out.println("result_3 = " + result_3); // 110
    }
}