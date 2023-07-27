import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

public class Problem_03_Deque {
    public static int[] solution(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int num : arr) { //
            if (deque.isEmpty() || deque.peekLast() != num) {
                deque.addLast(num);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];

        }

        for (Integer integer : deque) {

        }

        for (int i = 0; i < ; i++) {
            //fori 또는 itar
        }

        for (Integer integer : deque) {
            //iter
        }

        int a = 5; // opt+shift+ent
        //opt cmd l

        int[] answer = new int[deque.size()];

        int index =0;
        for(int num : deque) {
            answer[index++] = num;
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,1,3,3,0,1,1};
        int[] arr2 = {4,4,4,3,3};
        int[] answer1 = {};
        int[] answer2 = {};
        answer1 = Problem_03_Deque.solution(arr1);
        answer2 = Problem_03_Deque.solution(arr2);

        System.out.println("answer1 = " + Arrays.toString(answer1));// 1, 3, 0, 1
        System.out.println("answer2 = " + Arrays.toString(answer2));// 4, 3
    }
}
