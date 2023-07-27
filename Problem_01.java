import java.util.HashMap;

public class Problem_01 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/42576
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>(); // key 중복 안됨(확인 필요)

        for (String player : participant)
            map.put(player, map.getOrDefault(player, 0) + 1);
        for (String player : completion)
            map.put(player, map.get(player) - 1);

        for (String key : map.keySet()) { //순서 무관
            if (map.get(key) != 0)
                return key;
        }

        return "";
    }

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String answer = solution(participant, completion);
        System.out.println("answer: " + answer);
    }
}
