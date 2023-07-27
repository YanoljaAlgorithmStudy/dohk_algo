import java.util.*;
//import java.util.ArrayList;

public class Problem_03_ArrayList {
    public static int[] solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int num : arr) {
            if (answer.isEmpty() || answer.get(answer.size() - 1) != num) {
                answer.add(num);
            }
        }

        int[] intArray = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            intArray[i] = answer.get(i);
        }

        return intArray;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,1,3,3,0,1,1};
        int[] arr2 = {4,4,4,3,3};
        int[] answer1 = {};
        int[] answer2 = {};
        answer1 = Problem_03_ArrayList.solution(arr1);
        answer2 = Problem_03_ArrayList.solution(arr2);

        System.out.println("answer1 = " + Arrays.toString(answer1));// 1, 3, 0, 1
        System.out.println("answer2 = " + Arrays.toString(answer2));// 4, 3
    }
}
