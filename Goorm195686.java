import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Goorm195686 {
    //https://level.goorm.io/l/challenge/goormthon-challenge
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> k = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
           k.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        int maximum = Collections.max(k);
        int maximumIdx = k.indexOf(maximum);

        for (int i = 0; i < k.size(); i++) {
            if(i <= maximumIdx || k.get(i) == maximum) {
                answer += k.get(i);
            } else {
                if(k.get(i) < maximum) {
                    answer += k.get(i);
                    maximum = k.get(i);
                } else {
                    answer = 0;
                    break;
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
