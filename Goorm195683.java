import java.io.*;
import java.util.StringTokenizer;

// https://level.goorm.io/exam/195683/%EC%9A%B4%EB%8F%99-%EC%A4%91%EB%8F%85-%ED%94%8C%EB%A0%88%EC%9D%B4%EC%96%B4/quiz/1
public class Goorm195683 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println("Hello Goorm! Your input is " + input);
        
        int weight, repeat;
        StringTokenizer st = new StringTokenizer(input);
        weight = Integer.parseInt(st.nextToken());
        repeat = Integer.parseInt(st.nextToken());
        
        float RM = (float)weight * (1 + ((float)repeat/30));
        int result = (int) RM;


        System.out.println(result);
    }
}
