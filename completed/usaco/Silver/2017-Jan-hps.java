import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("hps.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        int N = Integer.parseInt(f.readLine());
        int[] rangeSumH = new int[N];
        int[] rangeSumP = new int[N];
        int[] rangeSumS = new int[N];
        for(int i = 0; i < N; i++) {
            rangeSumH[i] = i > 0 ? rangeSumH[i-1] : 0;
            rangeSumP[i] = i > 0 ? rangeSumP[i-1] : 0;
            rangeSumS[i] = i > 0 ? rangeSumS[i-1] : 0;
            char gesture = f.readLine().charAt(0);
            if(gesture == 'H') {
                rangeSumH[i]++;
            } else if(gesture == 'P') {
                rangeSumP[i]++;
            } else {
                rangeSumS[i]++;
            }
        }
        int maxWins = 0;
        for(int i = 0; i < N; i++) {
            int firstGestureH = rangeSumH[i];
            int firstGestureP = rangeSumP[i];
            int firstGestureS = rangeSumS[i];
            int secondGestureH = rangeSumH[N-1]-rangeSumH[i];
            int secondGestureP = rangeSumP[N-1]-rangeSumP[i];
            int secondGestureS = rangeSumS[N-1]-rangeSumS[i];
            int maxFirstGesture = Math.max(firstGestureH,Math.max(firstGestureP,firstGestureS));
            int maxSecondGesture = Math.max(secondGestureH,Math.max(secondGestureP,secondGestureS));
            maxWins = Math.max(maxWins,maxFirstGesture+maxSecondGesture);
        }
        out.println(maxWins);
        f.close();
        out.close();
    }
}
