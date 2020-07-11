import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = f.nextInt();
        for(int t = 0; t < T; t++){
            f.nextInt();
            f.nextInt();
            int F = f.nextInt();
            int[] sortedByX = new int[F];
            int[] sortedByY = new int[F];
            for(int i = 0; i < F; i++){
                sortedByX[i] = f.nextInt();
                sortedByY[i] = f.nextInt();
            }
            Arrays.sort(sortedByX);
            Arrays.sort(sortedByY);
            int x = sortedByX[(F-1)/2];
            int y = sortedByY[(F-1)/2];
            out.println("(Street: " + x + ", Avenue: " + y + ")");
        }
        f.close();
        out.close();
    }
}
