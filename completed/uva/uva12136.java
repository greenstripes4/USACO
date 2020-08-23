import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int t = 1; t <= N; t++) {
            StringTokenizer st1 = new StringTokenizer(f.readLine());
            String[] wifeStart = st1.nextToken().split(":");
            String[] wifeEnd = st1.nextToken().split(":");
            int wifeHourStart = Integer.parseInt(wifeStart[0]);
            int wifeMinuteStart = Integer.parseInt(wifeStart[1]);
            int wifeHourEnd = Integer.parseInt(wifeEnd[0]);
            int wifeMinuteEnd = Integer.parseInt(wifeEnd[1]);
            StringTokenizer st2 = new StringTokenizer(f.readLine());
            String[] meetingStart = st2.nextToken().split(":");
            String[] meetingEnd = st2.nextToken().split(":");
            int meetingHourStart = Integer.parseInt(meetingStart[0]);
            int meetingMinuteStart = Integer.parseInt(meetingStart[1]);
            int meetingHourEnd = Integer.parseInt(meetingEnd[0]);
            int meetingMinuteEnd = Integer.parseInt(meetingEnd[1]);
            int scaledWifeStart = wifeHourStart*60+wifeMinuteStart;
            int scaledWifeEnd = wifeHourEnd*60+wifeMinuteEnd;
            int scaledMeetingStart = meetingHourStart*60+meetingMinuteStart;
            int scaledMeetingEnd = meetingHourEnd*60+meetingMinuteEnd;
            out.print("Case " + t + ": ");
            if(scaledMeetingEnd < scaledWifeStart || scaledMeetingStart > scaledWifeEnd) {
                out.println("Hits Meeting");
            } else {
                out.println("Mrs Meeting");
            }
        }
        f.close();
        out.close();
    }
}
