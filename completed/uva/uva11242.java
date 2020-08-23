import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int F = f.nextInt();
            if(F == 0) {
                break;
            }
            int R = f.nextInt();
            int[] frontCluster = new int[F];
            int[] rearCluster = new int[R];
            for(int i = 0; i < F; i++) {
                frontCluster[i] = f.nextInt();
            }
            for(int i = 0; i < R; i++) {
                rearCluster[i] = f.nextInt();
            }
            double[] driveRatios = new double[F*R];
            int index = 0;
            for(int i = 0; i < F; i++) {
                for(int j = 0; j < R; j++) {
                    driveRatios[index++] = rearCluster[j]*1.0/frontCluster[i];
                }
            }
            Arrays.sort(driveRatios);
            double maxSpread = 0;
            for(int i = 0; i < F*R-1; i++) {
                maxSpread = Math.max(maxSpread,driveRatios[i+1]/driveRatios[i]);
            }
            out.printf("%.2f\n",maxSpread);
        }
        f.close();
        out.close();
    }
}
