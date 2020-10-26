import java.io.*;
import java.util.*;

public class Main{
    private static class TrafficSignal {
        private double L;
        private int GY;
        private int R;
        private TrafficSignal(double L, int GY, int R) {
            this.L = L;
            this.GY = GY;
            this.R = R;
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcase = 1;
        while(true) {
            int N = f.nextInt();
            if(N == -1) {
                break;
            }
            TrafficSignal[] trafficSignals = new TrafficSignal[N];
            for(int i = 0; i < N; i++) {
                trafficSignals[i] = new TrafficSignal(f.nextDouble(), f.nextInt()+f.nextInt(), f.nextInt());
            }
            out.print("Case " + testcase + ":" );
            int lastConsecutiveValid = -1;
            boolean first = true;
            for(int i = 30; i <= 61; i++) {
                boolean valid = i <= 60;
                for(TrafficSignal j: trafficSignals) {
                    double travelTime = j.L*3600/i;
                    if(!(travelTime%(j.GY+j.R) <= j.GY)) {
                        valid = false;
                        break;
                    }
                }
                if(!valid && lastConsecutiveValid != -1) {
                    if((i-1) != lastConsecutiveValid) {
                        out.print("-" + (i-1));
                    }
                    lastConsecutiveValid = -1;
                } else if(valid && lastConsecutiveValid == -1) {
                    out.print((first ? "" : ",") + " " + i);
                    first = false;
                    lastConsecutiveValid = i;
                }
            }
            out.println(first ? " No acceptable speeds." : "");
            testcase++;
        }
        f.close();
        out.close();
    }
}
