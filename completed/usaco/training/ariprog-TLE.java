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
        HashSet<Integer> allBisquares = new HashSet<>();
        for(int i = 0; i <= M; i++){
            for(int j = 0; j <= M; j++){
                allBisquares.add(i*i + j*j);
            }
        }
        int[] allB = new int[allBisquares.size()];
        int ind = 0;
        for(int k: allBisquares){
            allB[ind] = k;
            ind++;
        }
        Arrays.sort(allB);
        boolean isProg = false;
        for(int l = 1; l <= allB[allB.length-1] - allB[0]; l++){
            for(int m = 0; m < allB.length; m++){
                int end = allB[m];
                int n;
                for(n = 0; n < N - 1; n++){
                    if(!allBisquares.contains(end + l)){
                        break;
                    }
                    end += l;
                }
                if(n == N - 1){
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
