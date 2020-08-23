import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int b = f.nextInt();
        for(int r = 1; r <= b; r++) {
            int s = f.nextInt();
            int beginStop = 1;
            int endStop = 2;
            int tempBeginStop = 1;
            int tempEndStop;
            int maximumNiceness = 0;
            int currentNiceness = 0;
            for(int i = 1; i < s; i++) {
                currentNiceness += f.nextInt();
                if(currentNiceness > maximumNiceness) {
                    maximumNiceness = currentNiceness;
                    beginStop = tempBeginStop;
                    endStop = i+1;
                } else if(currentNiceness < 0) {
                    currentNiceness = 0;
                    tempBeginStop = i+1;
                } else {
                    tempEndStop = i+1;
                    if(tempEndStop-tempBeginStop > endStop-beginStop && currentNiceness == maximumNiceness) {
                        beginStop = tempBeginStop;
                        endStop = tempEndStop;
                    }
                }
            }
            out.println(maximumNiceness > 0 ? "The nicest part of route " + r + " is between stops " + beginStop + " and " + endStop : "Route " + r + " has no nice parts");
        }
        f.close();
        out.close();
    }
}
