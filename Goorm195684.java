import java.io.*;
import java.util.StringTokenizer;

public class Goorm195684 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int functionNum = Integer.parseInt(br.readLine());

        int startHour, startMinute;
        StringTokenizer st = new StringTokenizer(br.readLine());
        startHour = Integer.parseInt(st.nextToken());
        startMinute = Integer.parseInt(st.nextToken());

        int elapsedTime = 0;
        for (int i = 0; i < functionNum; i++) {
            elapsedTime += Integer.parseInt(br.readLine());
        }

        int parsedHour = elapsedTime / 60;
        int parsedMin = elapsedTime % 60;

        int resultHour = startHour+parsedHour;
        int resultMin = startMinute+parsedMin;

        int postHour = resultMin / 60;
        int postMin = resultMin % 60;

        resultHour+=postHour;
        resultHour%=24;
        resultMin=postMin;

        System.out.print(resultHour+" "+resultMin);
    }
}
