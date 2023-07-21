import java.util.Map;
import java.util.HashMap;

public class Problem_02 {
    public static String solution(int[] numbers, String hand){
        String answer = "";

        //왼손의 현재 위치: L*
        int currentLeft = 11;
        //오른손의 현재 위치: R#
        int currentRight = 12;

        //현재 위치에 따른 거리를 계속 업데이트
        //L: {1:0, 4:0, 7:0}
        //R: {3:0, 6:0, 9:0}

        Map<Integer, Integer> leftDistance = new HashMap<>();
        leftDistance.put(1, 0);
        leftDistance.put(4, 0);
        leftDistance.put(7, 0);
        leftDistance.put(3, 10000);
        leftDistance.put(6, 10000);
        leftDistance.put(9, 10000);
        leftDistance.put(2, 4);
        leftDistance.put(5, 3);
        leftDistance.put(8, 2);
        leftDistance.put(0, 0);

        Map<Integer, Integer> rightDistance = new HashMap<>();
        rightDistance.put(3, 0);
        rightDistance.put(6, 0);
        rightDistance.put(9, 0);
        rightDistance.put(1, 10000);
        rightDistance.put(4, 10000);
        rightDistance.put(7, 10000);
        rightDistance.put(2, 4);
        rightDistance.put(5, 3);
        rightDistance.put(8, 2);
        rightDistance.put(0, 0);

        for (int num : numbers) {
            if (leftDistance.get(num) < rightDistance.get(num)) {
                currentLeft = num;
                answer += "L";
                leftDistance = setDistance(currentLeft, leftDistance, true);
            } else if (leftDistance.get(num) > rightDistance.get(num)) {
                currentRight = num;
                answer += "R";
                rightDistance = setDistance(currentRight, rightDistance, false);
            } else {
                if (hand.equals("left")) {
                    currentLeft = num;
                    answer += "L";
                    leftDistance = setDistance(currentLeft, leftDistance, true);
                } else { // hand.equals("right")
                    currentRight = num;
                    answer += "R";
                    rightDistance = setDistance(currentRight, rightDistance, false);
                }
            }
        }

        return answer;
    }

    public static Map<Integer, Integer> setDistance(int currentPosition, Map<Integer, Integer> distanceMap, boolean isLeft) {
        //L*=R#: {2:4, 5:3, 8:2, 0:0 or inf}
        //L1=R3: {2:1, 5:2, 8:3, 0:4}
        //L2=R2: {2:0, 5:1, 8:2, 0:3}
        //L4=R6: {2:2, 5:1, 8:2, 0:3}
        //L5=R5: {2:1, 5:0, 8:1, 0:2}
        //L7=R9: {2:3, 5:2, 8:1, 0:2}
        //L8=R8: {2:2, 5:1, 8:0, 0:1}
        //L0=R0: {2:3, 5:2, 8:0, 0:0}
        int[] key = {2, 5, 8, 0};
        int[] val_L1R3 = {1, 2, 3, 4};
        int[] val_L2R2 = {0, 1, 2, 3};
        int[] val_L4R6 = {2, 1, 2, 3};
        int[] val_L5R5 = {1, 0, 1, 2};
        int[] val_L7R9 = {3, 2, 1, 2};
        int[] val_L8R8 = {2, 1, 0, 1};
        int[] val_L0R0 = {3, 2, 1, 0};
        Map<Integer, int[]> val_left = new HashMap<>();
        val_left.put(1, val_L1R3);
        val_left.put(2, val_L2R2);
        val_left.put(4, val_L4R6);
        val_left.put(5, val_L5R5);
        val_left.put(7, val_L7R9);
        val_left.put(8, val_L8R8);
        val_left.put(0, val_L0R0);
        Map<Integer, int[]> val_right = new HashMap<>();
        val_right.put(3, val_L1R3);
        val_right.put(2, val_L2R2);
        val_right.put(6, val_L4R6);
        val_right.put(5, val_L5R5);
        val_right.put(9, val_L7R9);
        val_right.put(8, val_L8R8);
        val_right.put(0, val_L0R0);

        for(int i=0 ; i<key.length;i++){
            if (isLeft) {
                distanceMap.put(key[i], val_left.get(currentPosition)[i]);
            }
            else {
                distanceMap.put(key[i], val_right.get(currentPosition)[i]);
            }
        }

        return distanceMap;
    }

    public static void main(String[] args){
        int[] numbers_1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand_1 = "right";
        int[] numbers_2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand_2 = "left";
        int[] numbers_3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand_3 = "right";

        String answer_1 = solution(numbers_1, hand_1);
        String answer_2 = solution(numbers_2, hand_2);
        String answer_3 = solution(numbers_3, hand_3);

        System.out.println(answer_1);
        System.out.println(answer_2);
        System.out.println(answer_3);
        // LRLLLRLLRRL
        // LRLLRRLLLRR
        // LLRLLRLLRL
    }
}
//1, 4, 7: 무조건 L
//3, 6, 9: 무조건 R
//2, 5, 8, 0: 거리를 먼저 따지고, 같은 거리인 경우 주손잡이를 따른다.
//처음부터 2, 5, 8, 0으로 접근하는 경우