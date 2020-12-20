import java.io.*;
import java.util.*;

public class Main {
    private static int count(boolean[][] cows, int startI, int endI, int startJ, int endJ, boolean target) {
        int num = 0;
        for(int i = startI; i < endI; i++) {
            for(int j = startJ; j < endJ; j++) {
                if(cows[i][j] == target) {
                    num++;
                }
            }
        }
        return num;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("leftout.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("leftout.out")));
        int N = Integer.parseInt(f.readLine());
        boolean[][] cows = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            char[] temp = f.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                cows[i][j] = temp[j] == 'R';
            }
        }
        for(int i = 0; i < N; i++) {
            if(cows[i][0]) {
                for(int j = 0; j < N; j++) {
                    cows[i][j] = !cows[i][j];
                }
            }
        }
        for(int i = 1; i < N; i++) {
            if(cows[0][i]) {
                for(int j = 0; j < N; j++) {
                    cows[j][i] = !cows[j][i];
                }
            }
        }
        if(count(cows, 1, N, 1, N, false) == 0) {
            out.println("1 1");
        } else if(count(cows, 1, N, 1, N, true) == N-1) {
            boolean found = false;
            for(int i = 1; i < N; i++) {
                if(count(cows, i, i+1, 1, N, true) == N-1) {
                    found = true;
                    out.println((i+1) + " 1");
                    break;
                }
            }
            if(!found) {
                for(int i = 1; i < N; i++) {
                    if(count(cows, 1, N, i, i+1, true) == N-1) {
                        found = true;
                        out.println("1 " + (i+1));
                        break;
                    }
                }
            }
            if(!found) {
                out.println(-1);
            }
        } else if(count(cows, 1, N, 1, N, true) == 1) {
            boolean found = false;
            for(int i = 1; i < N; i++) {
                for(int j = 1; j < N; j++) {
                    if(cows[i][j]) {
                        found = true;
                        out.println((i+1) + " " + (j+1));
                        break;
                    }
                }
                if(found) {
                    break;
                }
            }
        } else {
            out.println(-1);
        }
        f.close();
        out.close();
    }
}
