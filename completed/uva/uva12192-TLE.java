import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int N = f.nextInt();
            int M = f.nextInt();
            if(N == 0 && M == 0) {
                break;
            }
            int[][] H = new int[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    H[i][j] = f.nextInt();
                }
            }
            int Q = f.nextInt();
            for(int i = 0; i < Q; i++) {
                int L = f.nextInt();
                int U = f.nextInt();
                int minSide = 1;
                int maxSide = Math.min(N,M);
                int bestSide = 0;
                while(minSide <= maxSide) {
                    int midSide = (minSide+maxSide)/2;
                    boolean validSide = false;
                    for(int j = 0; j <= N-midSide; j++) {
                        for(int k = 0; k <= M-midSide; k++) {
                            boolean validRectangle = true;
                            for(int l = 0; l < midSide; l++) {
                                for(int m = 0; m < midSide; m++) {
                                    if(H[j+l][k+m] < L || H[j+l][k+m] > U) {
                                        validRectangle = false;
                                        break;
                                    }
                                }
                                if(!validRectangle) {
                                    break;
                                }
                            }
                            if(validRectangle) {
                                validSide = true;
                                break;
                            }
                        }
                        if(validSide) {
                            break;
                        }
                    }
                    if(validSide) {
                        bestSide = midSide;
                        minSide = midSide+1;
                    } else {
                        maxSide = midSide-1;
                    }
                }
                out.println(bestSide);
            }
            out.println("-");
        }
        f.close();
        out.close();
    }
}
