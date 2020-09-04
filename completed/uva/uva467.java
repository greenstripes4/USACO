import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        int testcase = 1;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int[] greenSignals = new int[3602];
            int signals = 0;
            int nextRed = Integer.MAX_VALUE;
            while(st.hasMoreTokens()) {
                int cycleTime = Integer.parseInt(st.nextToken());
                nextRed = Math.min(nextRed,cycleTime);
                int currentTime = -cycleTime;
                while(currentTime < 3602) {
                    currentTime += cycleTime;
                    for(int i = 0; i < cycleTime-5 && currentTime < 3601; i++) {
                        currentTime++;
                        greenSignals[currentTime]++;
                    }
                    currentTime += 5;
                }
                signals++;
            }
            boolean found = false;
            for(int i = nextRed; i < 3602; i++) {
                if(greenSignals[i] == signals) {
                    out.println("Set " + testcase + " synchs again at " + (i-1)/60 + " minute(s) and " + (i-1)%60 + " second(s) after all turning green.");
                    found = true;
                    break;
                }
            }
            if(!found) {
                out.println("Set " + testcase + " is unable to synch after one hour.");
            }
            testcase++;
        }
        f.close();
        out.close();
    }
}
