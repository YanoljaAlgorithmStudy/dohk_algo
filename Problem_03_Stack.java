import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Problem_03_Stack {
    public static int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() != num) {
                stack.add(num);
            }
        }

        int[] answer = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            answer[i] = stack.get(i);
        }

        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,1,3,3,0,1,1};
        int[] arr2 = {4,4,4,3,3};
        int[] answer1 = {};
        int[] answer2 = {};
        answer1 = Problem_03_Stack.solution(arr1);
        answer2 = Problem_03_Stack.solution(arr2);

        System.out.println("answer1 = " + Arrays.toString(answer1));// 1, 3, 0, 1
        System.out.println("answer2 = " + Arrays.toString(answer2));// 4, 3
    }
}
