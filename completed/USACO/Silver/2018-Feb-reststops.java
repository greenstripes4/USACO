import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("reststops.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int rF = Integer.parseInt(st.nextToken());
        int rB = Integer.parseInt(st.nextToken());
        int[][] restStops = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            restStops[i][0] = Integer.parseInt(st.nextToken());
            restStops[i][1] = Integer.parseInt(st.nextToken());
        }
        long tastinessUnits = 0;
        int currentStop = -1;
        while(currentStop < N-1) {
            int nextStop = currentStop+1;
            for(int i = currentStop+2; i < N; i++) {
                if(restStops[i][1] > restStops[nextStop][1]) {
                    nextStop = i;
                }
            }
            long distanceTraveled = (restStops[nextStop][0]-(currentStop < 0 ? 0 : restStops[currentStop][0]));
            tastinessUnits += restStops[nextStop][1]*distanceTraveled*(rF-rB);
            currentStop = nextStop;
        }
        out.println(tastinessUnits);
        f.close();
        out.close();
    }
}
