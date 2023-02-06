/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.Arrays;

public class ariprog {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        int N = Integer.parseInt(f.readLine());
        int M = Integer.parseInt(f.readLine());
        boolean[] allBisquares = new boolean[125001];
        int[] tempB = new int[30000];
        int numB=0;
        for(int i = 0; i <= M; i++){
            for(int j = 0; j <= M; j++){
                int temp =i*i + j*j;
                if(!allBisquares[temp]) {
                    tempB[numB] = temp;
                    numB++;
                }
                allBisquares[temp] = true;
            }
        }
        int[] allB = Arrays.copyOfRange(tempB, 0, numB);
        Arrays.sort(allB);
        boolean isProg = false;
        int upper = 2*M*M;
        for(int l = 1; l <= upper/(N-1); l++){
            for(int m = 0; allB[m] <= (upper-((N-1)*l)); m++) {
                int end = allB[m];
                int n;
                for (n = 0; n < N - 1; n++) {
                    if (!allBisquares[end + l]) {
                        break;
                    }
                    end += l;
                }
                if (n == N - 1) {
                    out.println(allB[m] + " " + l);
                    isProg = true;
                }
            }
        }
        if(!isProg){
            out.println("NONE");
        }
        out.close();
        f.close();
    }
}
