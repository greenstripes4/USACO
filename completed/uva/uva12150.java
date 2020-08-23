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
            int N = f.nextInt();
            if(N == 0) {
                break;
            }
            int[] carNumbers = new int[N];
            int[] relativePositions = new int[N];
            for(int i = 0; i < N; i++) {
                carNumbers[i] = f.nextInt();
                relativePositions[i] = f.nextInt();
            }
            int[] startingGrid = new int[N];
            Arrays.fill(startingGrid,-1);
            boolean valid = true;
            for(int i = 0; i < N; i++) {
                int startPosition = i+relativePositions[i];
                if(startPosition < 0 || startPosition >= N || startingGrid[startPosition] != -1) {
                    valid = false;
                    break;
                }
                startingGrid[startPosition] = carNumbers[i];
            }
            if(valid) {
                out.print(startingGrid[0]);
                for(int i = 1; i < N; i++) {
                    out.print(" " + startingGrid[i]);
                }
                out.println();
            } else {
                out.println(-1);
            }
        }
        f.close();
        out.close();
    }
}
