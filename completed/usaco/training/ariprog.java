/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */
import java.util.*;
import java.io.*;

public class ariprog {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        int N = Integer.parseInt(f.readLine());
        int M = Integer.parseInt(f.readLine());
        boolean[] allBisquares = new boolean[125001];
        int[] tempB = new int[30000];
        HashSet<Integer> hashB = new HashSet<>();
        int numB=0;
        for(int i = 0; i <= M; i++){
            for(int j = 0; j <= M; j++){
                int temp =i*i + j*j;
                if(allBisquares[temp] == false) {
                    tempB[numB] = temp;
                    numB++;
                }
                hashB.add(temp);
                allBisquares[temp] = true;
            }
        }
        int[] allB = Arrays.copyOfRange(tempB, 0, numB);
        Arrays.sort(allB);
        boolean isProg = false;
        int upper = 2*M*M;
        for(int l = 1; l <= upper/(N-1); l++){
        //for(int l = 1; l <= allB[allB.length-1] - allB[0]; l++){
            for(int m = 0; allB[m]<=(upper-((N-1)*l)); m++) {
                int end = allB[m];
                int n;
                for (n = 0; n < N - 1; n++) {
                    // hash.get is 6 times slower than raw index
                    //if(!hashB.contains(end + l)){
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
