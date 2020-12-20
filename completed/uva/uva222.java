import java.io.*;
import java.util.*;

public class Main{
    private static double gC;
    private static double mPG;
    private static double[][] gasStations;
    private static double minC;
    private static void solve(int sI, double g, double c) {
        if(sI == gasStations.length-1) {
            minC = Math.min(minC, c);
            return;
        }
        double nG = (gasStations[sI+1][0]-gasStations[sI][0])/mPG;
        if(g >= nG) {
            solve(sI+1, g-nG, c);
        }
        if(sI > 0 && (g <= gC/2 || g < nG)) {
            solve(sI+1, gC-nG, round((c+(gC-g)*gasStations[sI][1])+2));
        }
    }
    private static double round(double val) {
        val = (int)(val*1000);
        if(val%10 < 5) {
            val -= val%10;
        } else {
            val += 10-val%10;
        }
        val /= 1000;
        return val;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcase = 1;
        while(true) {
            double dL = Double.parseDouble(f.readLine());
            if(dL < 0) {
                break;
            }
            StringTokenizer st = new StringTokenizer(f.readLine());
            gC = Double.parseDouble(st.nextToken());
            mPG = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());
            int gS = Integer.parseInt(st.nextToken());
            gasStations = new double[gS+2][2];
            gasStations[0][0] = 0;
            for(int i = 1; i <= gS; i++) {
                st = new StringTokenizer(f.readLine());
                gasStations[i][0] = Double.parseDouble(st.nextToken());
                gasStations[i][1] = Double.parseDouble(st.nextToken())/100;
            }
            gasStations[gS+1][0] = dL;
            minC = Double.MAX_VALUE;
            solve(0, gC, c);
            out.println("Data Set #" + testcase);
            out.println("minimum cost = $" + String.format("%.2f", minC));
            testcase++;
        }
        f.close();
        out.close();
    }
}
