import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class vacuumVoyager {
    private static int maximumEnergyLeft(int[][] E, int r, int c, int C) {
        if(r == E.length-1 && c == E.length-1) {
            return C;
        }
        C += E[r][c];
        int firstCandidate = 0;
        int secondCandidate = 0;
        if(r != E.length-1) {
            firstCandidate = maximumEnergyLeft(E,r+1,c,C);
        }
        if(c != E.length-1) {
            secondCandidate = maximumEnergyLeft(E,r,c+1,C);
        }
        return Math.max(firstCandidate,secondCandidate);
    }
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        int C = f.nextInt();
        int[][] E = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                E[i][j] = f.nextInt();
            }
        }
        out.println(maximumEnergyLeft(E,0,0,C));
        f.close();
        out.close();
    }
}
